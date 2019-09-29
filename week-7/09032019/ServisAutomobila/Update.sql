--1
UPDATE Kupovina
SET	Cijena = 25000
WHERE idA = 	
(SELECT Kupovina.IdA
FROM Kupac JOIN	Kupovina
			ON Kupac.Id = Kupovina.IdK
			JOIN Automobil
			ON Kupovina.IdA = Automobil.id
			JOIN Model
			ON Model.id = Automobil.IdM
			WHERE Kupac.Ime = "Zoran" AND Model.Marka = "Audi" and Model.Model = "A4");
			
--2		
UPDATE Nabavka
SET Cijena = Cijena +(Cijena*0.10)
WHERE IdA = 5 
or IdA = 6
or Ida = 7
or IdA = 8;