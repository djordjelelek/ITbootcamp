--1.
Select *
from Fakultet
WHERE "Drzavni/Privatni" = 'D'

--2.
Select Naziv
from Fakultet
WHERE "Drzavni/Privatni" = 'P'

--3.
Select count (*)
from Fakultet
WHERE "Drzavni/Privatni" = 'D'

--4.
Select avg (BrojStudenata)
from Fakultet

--5.
Select avg (BrojStudenata)
from Fakultet
WHERE "Drzavni/Privatni" = 'D'

--6.
Select DISTINCT Grad
from Fakultet
--WHERE "Drzavni/Privatni" = 'D'

--7.
SELECT sum (BrojStudenata)
FROM Fakultet

--8.
SELECT Ime, Prezime
from Student

--9.
SELECT *
from Student
WHERE GodinaStudija = 3

--10.
SELECT *, max(Prosek) 
FROM Student

--11.
SELECT *, max(Prosek) 
FROM Student
where GodinaStudija = 3

--12.
SELECT avg (Prosek)
FROM Student
WHERE GodinaStudija=4

--13.
SELECT avg (Prosek)
FROM Student
WHERE Pol='M'

--14.
SELECT *
FROM Student
WHERE Prosek is NULL

--15.
SELECT *
FROM Student
WHERE Prosek IS NOT NULL

--16.
SELECT *
FROM Student
WHERE Prosek >= (SELECT avg(Prosek)
FROM Student)




