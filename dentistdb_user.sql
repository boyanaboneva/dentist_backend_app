-- insert data into user table
INSERT INTO dentistdb.user (id, enabled, first_name, last_name, password, role, username) VALUES (1, 1, 'Wonder', 'Woman', '$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbVFzu', 'ROLE_USER', 'namhm');
INSERT INTO dentistdb.user (id, enabled, first_name, last_name, password, role, username) VALUES (2, 1, 'Bat', 'Man', '$2a$10$zxvEq8XzYEYtNjbkRsJEbukHeRx3XS6MDXHMu8cNuNsRfZJWwswDy', 'ROLE_ADMIN', 'admin');

-- insert data into diagnose table
INSERT INTO dentistdb.diagnose (id, name) VALUES (1, 'R корен');
INSERT INTO dentistdb.diagnose (id, name) VALUES (2, 'O обстурация');
INSERT INTO dentistdb.diagnose (id, name) VALUES (3, 'E липсващ зъб');
INSERT INTO dentistdb.diagnose (id, name) VALUES (4, 'K коронка');
INSERT INTO dentistdb.diagnose (id, name) VALUES (5, 'X изкуствен зъб');
INSERT INTO dentistdb.diagnose (id, name) VALUES (6, 'Pa парадонтоза');
INSERT INTO dentistdb.diagnose (id, name) VALUES (7, 'I II III степен подвижност');
INSERT INTO dentistdb.diagnose (id, name) VALUES (8, 'F фрактура');
INSERT INTO dentistdb.diagnose (id, name) VALUES (9, 'Impl зъбен имплант');
INSERT INTO dentistdb.diagnose (id, name) VALUES (10, 'Dsn свръхброен зъб');
INSERT INTO dentistdb.diagnose (id, name) VALUES (14, 'C кариес');
INSERT INTO dentistdb.diagnose (id, name) VALUES (15, 'P пулпит');
INSERT INTO dentistdb.diagnose (id, name) VALUES (16, 'G периодонтит');
INSERT INTO dentistdb.diagnose (id, name) VALUES (34, 'екстракция на корен');

-- insert data into manipulation table
INSERT INTO dentistdb.manipulation (id, manipulation_code, manipulation_type, nhif_price_over_18, nhif_price_under_18, patient_price_over_18, patient_price_under_18) VALUES (2, 331, 'Лечение на пулпит на временен зъб', 21.92, null, 4.7, null);
INSERT INTO dentistdb.manipulation (id, manipulation_code, manipulation_type, nhif_price_over_18, nhif_price_under_18, patient_price_over_18, patient_price_under_18) VALUES (3, 333, 'Лечение на пулпит на постоянен зъб', 68.93, null, 12.3, null);
INSERT INTO dentistdb.manipulation (id, manipulation_code, manipulation_type, nhif_price_over_18, nhif_price_under_18, patient_price_over_18, patient_price_under_18) VALUES (4, 332, 'Лечение на периодонтит на временен зъб', 21.92, null, 4.7, null);
INSERT INTO dentistdb.manipulation (id, manipulation_code, manipulation_type, nhif_price_over_18, nhif_price_under_18, patient_price_over_18, patient_price_under_18) VALUES (5, 334, 'Лечение на периодонтит на постоянен зъб', 68.93, null, 12.3, null);
INSERT INTO dentistdb.manipulation (id, manipulation_code, manipulation_type, nhif_price_over_18, nhif_price_under_18, patient_price_over_18, patient_price_under_18) VALUES (6, 101, 'Профилактичен преглед със снемане на зъбен статус', 8.2, 8.2, 1.8, 1.8);
INSERT INTO dentistdb.manipulation (id, manipulation_code, manipulation_type, nhif_price_over_18, nhif_price_under_18, patient_price_over_18, patient_price_under_18) VALUES (7, 602, 'Имплантиране на изкуствен зъб', null, null, 100, 200);
INSERT INTO dentistdb.manipulation (id, manipulation_code, manipulation_type, nhif_price_over_18, nhif_price_under_18, patient_price_over_18, patient_price_under_18) VALUES (11, 301, 'Обстурация с пломба от амалгама', 32.4, 28.4, 0, 4);
INSERT INTO dentistdb.manipulation (id, manipulation_code, manipulation_type, nhif_price_over_18, nhif_price_under_18, patient_price_over_18, patient_price_under_18) VALUES (12, 302, 'Обстурация с пломба от химиополимер', 32.4, 28.4, 0, 4);
INSERT INTO dentistdb.manipulation (id, manipulation_code, manipulation_type, nhif_price_over_18, nhif_price_under_18, patient_price_over_18, patient_price_under_18) VALUES (29, 509, 'Екстракция на постоянен зъб с анестезия', 32.4, 28.4, 0, 4);
INSERT INTO dentistdb.manipulation (id, manipulation_code, manipulation_type, nhif_price_over_18, nhif_price_under_18, patient_price_over_18, patient_price_under_18) VALUES (30, 510, 'Екстракция на постоянен зъб без анестезия', 29.8, 25.3, 0, 3);
INSERT INTO dentistdb.manipulation (id, manipulation_code, manipulation_type, nhif_price_over_18, nhif_price_under_18, patient_price_over_18, patient_price_under_18) VALUES (31, 507, 'Екстракция на временен зъб без анестезия', 10, 0, 0, 0);
INSERT INTO dentistdb.manipulation (id, manipulation_code, manipulation_type, nhif_price_over_18, nhif_price_under_18, patient_price_over_18, patient_price_under_18) VALUES (32, 508, 'Екстракция на временен зъб с анестезия', 13, null, 0, null);

-- insert data into patient table
INSERT INTO dentistdb.patient (id, egn, first_name, last_name) VALUES (1, 1903127834, 'Wonder', 'Woman');
INSERT INTO dentistdb.patient (id, egn, first_name, last_name) VALUES (9, 7812314587, 'Bat', 'Man');

-- insert data into status table
INSERT INTO dentistdb.status (id, date, tooth_status, patient_id) VALUES (28, '2021-02-08 22:32:30', '37C', 9);
INSERT INTO dentistdb.status (id, date, tooth_status, patient_id) VALUES (30, '2021-02-08 22:32:30', '17C', 1);

-- insert data into history table
INSERT INTO dentistdb.history (id, patient_id, tooth_code, diagnose_description, manipulation_description, minutes_counter, diagnose_id, manipulation_id, date) VALUES (25, 1, '15 C', '0', 'продължително лечение на кариес', 0, 14, 12, '2021-01-26 21:43:17');
INSERT INTO dentistdb.history (id, patient_id, tooth_code, diagnose_description, manipulation_description, minutes_counter, diagnose_id, manipulation_id, date) VALUES (26, 9, '23 X', '0', 'поставяне на изкуствен зъб', 180, 5, 7, '2021-01-26 21:43:17');

INSERT INTO dentistdb.hibernate_sequence (next_val) VALUES (47);
INSERT INTO dentistdb.hibernate_sequence (next_val) VALUES (47);