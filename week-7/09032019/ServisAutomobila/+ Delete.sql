--1
DELETE FROM Kupovina
WHERE IdA = 3 or IdA = 4;
DELETE FROM Nabavka
WHERE IdA = 3 or IdA = 4;
DELETE FROM Automobil
WHERE IdM = 2;
DELETE FROM Model    -- ne znam sta je problem, provjeravam ga vec 3 sata; 
WHERE Id = 2;        -- ne postoji nigdje foreign key, ali ga svejedno ne moze da izbrise


--2
DELETE from Nabavka
WHERE Nabavka.idA IN (SELECT Id FROM Automobil) 
AND (SELECT Id FROM Automobil) NOT IN (SELECT IdA FROM Kupovina)

DELETE FROM Automobil
WHERE Automobil.Id NOT IN (SELECT IdA FROM Kupovina)
