-- users
INSERT INTO tickets.users (id, email, name, password) VALUES (1, 'ticket@test.com', '테스터', '12345');

-- vendors
INSERT INTO tickets.vendors (id, business_license, email, name, password) VALUES (1, '12345-6789', 'vendoer@test.com', '공연대장', '12345');

-- venues
INSERT INTO tickets.venues (capacity, id, vendor_id, description, name) VALUES (50, 1, 1, '단 하나뿐인 공연장입니다.', '테이퍼드');

-- seats
INSERT INTO tickets.seats (id, venue_id, name) VALUES (1, 1, 'A1');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (2, 1, 'A2');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (3, 1, 'A3');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (4, 1, 'A4');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (5, 1, 'A5');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (6, 1, 'A6');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (7, 1, 'A7');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (8, 1, 'A8');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (9, 1, 'A9');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (10, 1, 'A10');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (11, 1, 'B1');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (12, 1, 'B2');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (13, 1, 'B3');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (14, 1, 'B4');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (15, 1, 'B5');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (16, 1, 'B6');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (17, 1, 'B7');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (18, 1, 'B8');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (19, 1, 'B9');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (20, 1, 'B10');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (21, 1, 'C1');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (22, 1, 'C2');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (23, 1, 'C3');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (24, 1, 'C4');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (25, 1, 'C5');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (26, 1, 'C6');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (27, 1, 'C7');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (28, 1, 'C8');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (29, 1, 'C9');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (30, 1, 'C10');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (31, 1, 'D1');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (32, 1, 'D2');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (33, 1, 'D3');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (34, 1, 'D4');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (35, 1, 'D5');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (36, 1, 'D6');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (37, 1, 'D7');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (38, 1, 'D8');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (39, 1, 'D9');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (40, 1, 'D10');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (41, 1, 'E1');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (42, 1, 'E2');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (43, 1, 'E3');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (44, 1, 'E4');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (45, 1, 'E5');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (46, 1, 'E6');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (47, 1, 'E7');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (48, 1, 'E8');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (49, 1, 'E9');
INSERT INTO tickets.seats (id, venue_id, name) VALUES (50, 1, 'E10');

-- performance
INSERT INTO tickets.performances (end_time, start_time, date, id, venue_id, name) VALUES (20, 18, '2023-06-24 15:27:12', 1, 1, '오페라의 유령');
INSERT INTO tickets.performances (end_time, start_time, date, id, venue_id, name) VALUES (22, 20, '2023-06-24 15:27:19', 2, 1, '오페라의 유령');
INSERT INTO tickets.performances (end_time, start_time, date, id, venue_id, name) VALUES (20, 18, '2023-06-23 15:27:25', 3, 1, '오페라의 유령');
INSERT INTO tickets.performances (end_time, start_time, date, id, venue_id, name) VALUES (22, 20, '2023-06-23 15:27:27', 4, 1, '오페라의 유령');

-- grade
INSERT INTO tickets.grades (id, performance_id, price, name) VALUES (1, 1, 50000, 'A');
INSERT INTO tickets.grades (id, performance_id, price, name) VALUES (2, 1, 70000, 'S');
INSERT INTO tickets.grades (id, performance_id, price, name) VALUES (3, 1, 100000, 'VIP');

-- performance seats
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (3, 1, 1, 1, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (3, 2, 1, 2, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (3, 3, 1, 3, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (3, 4, 1, 4, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (3, 5, 1, 5, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (3, 6, 1, 6, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (3, 7, 1, 7, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (3, 8, 1, 8, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (3, 9, 1, 9, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (3, 10, 1, 10, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (2, 11, 1, 11, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (2, 12, 1, 12, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (2, 13, 1, 13, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (2, 14, 1, 14, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (2, 15, 1, 15, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (2, 16, 1, 16, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (2, 17, 1, 17, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (2, 18, 1, 18, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (2, 19, 1, 19, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (2, 20, 1, 20, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (2, 21, 1, 21, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (2, 22, 1, 22, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (2, 23, 1, 23, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (2, 24, 1, 24, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (2, 25, 1, 25, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 26, 1, 26, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 27, 1, 27, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 28, 1, 28, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 29, 1, 29, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 30, 1, 30, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 31, 1, 31, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 32, 1, 32, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 33, 1, 33, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 34, 1, 34, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 35, 1, 35, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 36, 1, 36, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 37, 1, 37, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 38, 1, 38, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 39, 1, 39, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 40, 1, 40, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 41, 1, 41, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 42, 1, 42, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 43, 1, 43, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 44, 1, 44, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 45, 1, 45, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 46, 1, 46, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 47, 1, 47, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 48, 1, 48, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 49, 1, 49, 'AVAILABLE');
INSERT INTO tickets.performance_seats (grade_id, id, performance_id, seat_id, seat_status) VALUES (1, 50, 1, 50, 'AVAILABLE');
