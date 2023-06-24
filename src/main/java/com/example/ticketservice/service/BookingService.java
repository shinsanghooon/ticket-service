package com.example.ticketservice.service;

import com.example.ticketservice.common.SeatStatus;
import com.example.ticketservice.model.dto.BookingRequest;
import com.example.ticketservice.model.dto.BookingResponse;
import com.example.ticketservice.model.dto.MyBookingSeatResponse;
import com.example.ticketservice.repository.BookingRepository;
import com.example.ticketservice.repository.BookingSeatRepository;
import com.example.ticketservice.repository.PerformanceSeatsRepository;
import com.example.ticketservice.repository.UserRepository;
import com.example.ticketservice.repository.entity.Booking;
import com.example.ticketservice.repository.entity.BookingSeat;
import com.example.ticketservice.repository.entity.Performance;
import com.example.ticketservice.repository.entity.PerformanceSeats;
import com.example.ticketservice.repository.entity.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookingService {

    private final BookingRepository bookingRepository;

    private final BookingSeatRepository bookingSeatRepository;

    private final UserRepository userRepository;

    private final PerformanceSeatsRepository performanceSeatsRepository;

    private final PerformanceService performanceService;

    private final PayService payService;

    @Transactional
    public void book(BookingRequest bookingRequest) {

        Performance performance = performanceService.findById(bookingRequest.getPerformanceId());

        // 사용자는 우선 고정한다.
        User user = userRepository.findById(1L)
            .orElseThrow(() -> new IllegalArgumentException("해당 사용자 정보를 찾을 수 없습니다."));

        Booking booking = bookingRequest.toEntity(user, performance);

        List<BookingSeat> bookingSeats = bookingRequest.getPerformanceSeatIds().stream()
            .map(id -> BookingSeat.builder()
                .performanceSeatId(id)
                .booking(booking)
                .build()
            ).toList();

        List<PerformanceSeats> bookedPerformanceSeats = performanceSeatsRepository.findAllById(
            bookingRequest.getPerformanceSeatIds());

        // check seat is already occupied
        checkOccupiedSeat(bookedPerformanceSeats);

        // check total payment compare to seat grade
        checkTotalPrice(bookingRequest, bookedPerformanceSeats);

        bookingRepository.save(booking);
        bookingSeatRepository.saveAll(bookingSeats);

        // update performance seat status
        updateSeatStatusToOccupied(bookedPerformanceSeats);

        payService.payForTickets(bookingRequest.getPaymentInfo(), booking.getTotalPayment());
    }

    private static void checkOccupiedSeat(List<PerformanceSeats> bookedPerformanceSeats) {
        bookedPerformanceSeats.stream()
            .filter(seat -> seat.getSeatStatus().equals(SeatStatus.OCCUPIED))
            .findAny()
            .ifPresent(m -> {
                throw new IllegalStateException(m.getSeat().getName() + "은 이미 예매된 좌석입니다.");
            });
    }

    private static void updateSeatStatusToOccupied(List<PerformanceSeats> bookedPerformanceSeats) {
        bookedPerformanceSeats
            .forEach(PerformanceSeats::changeStatusByBooking);
    }

    private static void checkTotalPrice(BookingRequest bookingRequest,
        List<PerformanceSeats> bookedPerformanceSeats) {
        long expectedTotalPrice = bookedPerformanceSeats.stream()
            .map(seat -> seat.getGrade().getPrice())
            .mapToLong(i -> i).sum();

        if (expectedTotalPrice != bookingRequest.getTotalPrice()) {
            throw new IllegalStateException("예매 좌석 가격 총합과 결제 요청 금액이 일치하지 않습니다.");
        }
    }

    public List<BookingResponse> getMyBookings() {

        // 사용자는 우선 고정한다.
        User user = userRepository.findById(1L)
            .orElseThrow(() -> new IllegalArgumentException("해당 사용자 정보를 찾을 수 없습니다."));

        List<Booking> myBookings = bookingRepository.findByUser(user);

        return myBookings.stream()
            .map((booking) -> {
                List<Long> bookedPerformanceSeats = bookingSeatRepository.findByBooking(booking).stream()
                    .map(BookingSeat::getPerformanceSeatId).toList();

                List<PerformanceSeats> bookedSeats = performanceSeatsRepository.findAllById(
                    bookedPerformanceSeats);

                List<MyBookingSeatResponse> myBookingSeatResponses = bookedSeats.stream()
                    .map((bookedSeat) -> MyBookingSeatResponse.builder()
                        .gradeName(bookedSeat.getGrade().getName())
                        .seatNumber(bookedSeat.getSeat().getName())
                        .build()).toList();

                return BookingResponse.builder()
                    .performanceId(booking.getPerformance().getId())
                    .performanceName(booking.getPerformance().getName())
                    .date(booking.getPerformance().getDate())
                    .startTime(booking.getPerformance().getStartTime())
                    .endTime(booking.getPerformance().getEndTime())
                    .seats(myBookingSeatResponses)
                    .build();
            }).toList();
    }
}
