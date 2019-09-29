--1
DELETE FROM Automobil
WHERE IdM = 2;
DELETE FROM Model
WHERE Id = 2;

--2 iz tabele Automobil izbacite sve automobile koji nisu prodati- nema ih u tabeli Kupljeni
DELETE FROM Automobil
WHERE Automobil.Id NOT IN (SELECT IdA FROM Kupovina);
SELECT DISTINCT Automobil.*
FROM Automobil, Kupovina
WHERE Automobil.Id NOT IN (SELECT IdA FROM Kupovina);