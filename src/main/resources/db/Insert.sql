-- PATIENT INSERTS
INSERT INTO Patients (name, last_name, symptom) VALUES ('Alan', 'Kalbermatter', 'headache');
INSERT INTO Patients (name, last_name, symptom) VALUES ('Sabrina', 'Cho', 'fever');
INSERT INTO Patients (name, last_name, symptom) VALUES ('Nicolas', 'Schmith', 'stomachache');
INSERT INTO Patients (name, last_name, symptom) VALUES ('Walter', 'Schurman', 'stomachache');

-- MEDICAL STAFF INSERT
INSERT INTO Medical_staff (name, specialty) VALUES ('Alan', 'pediatrician', 'Doctor');
INSERT INTO Medical_staff (name, specialty) VALUES ('Malena', 'cardiologist', 'Department head');
INSERT INTO Medical_staff (name, specialty) VALUES ('Marina', 'gynecologist', 'Doctor');
INSERT INTO Medical_staff (name, specialty) VALUES ('Austin', 'nurse', 'Intensive care assistant');

-- MEDICINE INSERT
INSERT INTO Medicine (name, price) VALUES ('Antibiotic', 3.80);
INSERT INTO Medicine (name, price) VALUES ('Ibuprofen', 1.30);
INSERT INTO Medicine (name, price) VALUES ('Benzodiazepines', 18.10);
INSERT INTO Medicine (name, price) VALUES ('Tylenol', 1.80);

-- APPOINTMENTS INSERT
INSERT INTO Appointments (date, description) VALUES (2021-12-07, "");
INSERT INTO Appointments (date, description) VALUES (2021-9-21, "");
INSERT INTO Appointments (date, description) VALUES (2021-7-19, "");
INSERT INTO Appointments (date, description) VALUES (2021-7-29, "");

-- BEDS INSERT
INSERT INTO Beds (room_number) VALUES (144);
INSERT INTO Beds (room_number) VALUES (22);
INSERT INTO Beds (room_number) VALUES (13);
INSERT INTO Beds (room_number) VALUES (203);

-- EVENTS INSERT
INSERT INTO Events (reason) VALUES ("charitable for pediatric operations");
INSERT INTO Events (reason) VALUES ("together for cancer");
INSERT INTO Events (reason) VALUES ("help public dining rooms");
INSERT INTO Events (reason) VALUES ("charitable for pediatric operations");

-- OPERATIONS INSERT
INSERT INTO Operations (date, reason) VALUES (2021-3-14, "heart operation");
INSERT INTO Operations (date, reason) VALUES (2021-12-16, "arm operation");
INSERT INTO Operations (date, reason) VALUES (2021-08-29, "leg operation");
INSERT INTO Operations (date, reason) VALUES (2021-01-03, "knees operation");




