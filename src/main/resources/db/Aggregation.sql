--SHOW THE PATIENT'S APPOINTMENTS WITH EACH DOCTOR
SELECT mydb.p.name AS 'Patients Names', mydb.p.symptom AS 'Patients Symptoms', mydb.ms.name AS 'Doctors names', mydb.a.date AS 'Appointments Date'
FROM Appointments AS a
	LEFT JOIN
	Patients AS p
    ON p.id = a.patients_id
	RIGHT JOIN
	Medical_staff AS d
    ON d.id = a.medical_staff_id
GROUP BY a.id
HAVING ms.specialty = 'Doctor';

--Show the Operation staff and the patient
SELECT s.name AS 'Surgeons names',
        p.name AS 'Patients names',
        o.reason AS 'Descriptions of the operations'
FROM Operations AS o
    INNER JOIN
    Patients AS p
    ON p.id = o.patients_id
    INNER JOIN
    Medical_staff AS s
    ON s.id = o.medical_staff_id
GROUP BY o.id


--COUNT THE PATIENTS
SELECT
    COUNT(Patients.name) AS 'Patients'
FROM
    Patients;

--See the most expensive medicines
SELECT m.name AS 'Medicines',
		MAX (m.price) AS 'Prices'
FROM Medicines AS m
GROUP BY Prices;

--See the che

--see the sum of the prices of all the medicines that have one prescription
SELECT (m.name) AS 'Medicines',
        SUM(m.price) AS 'Prices',
        p.id AS prescription
FROM Medicines AS m
LEFT JOIN
    Prescriptions AS
    ON p.id = m.prescription_id
GROUP BY p.id;


