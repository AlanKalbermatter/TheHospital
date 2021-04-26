/*SHOW THE PATIENT'S APPOINTMENTS WITH EACH DOCTOR*/

SELECT mydb.p.name AS 'Patients Names', mydb.p.symptom AS 'Patients Symptoms', mydb.ms.name AS 'Doctors names', mydb.a.date AS 'Appointments Date'
FROM Appointments AS a
	LEFT JOIN
	Patients AS p
    ON p.id = a.id
	RIGHT JOIN
	Medical_staff AS d
    ON d.id = a.id
HAVING ms.specialty = 'Doctor';

--#COUNT THE PATIENTS
--SELECT
--    COUNT(Patients.name) AS 'Patients'
--FROM
--    Patients;

