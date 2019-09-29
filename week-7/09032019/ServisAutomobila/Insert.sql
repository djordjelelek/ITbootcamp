INSERT INTO Model (Marka, Model, BrProdatih, BrNabavljenih, Profit)
VALUES ("BMW", "X6", 10, 20, 10000),
		("BMW", "x7", 5, 12, 14000),
		("Audi", "A4", 4, 10, 20000),
		("Audi", "A8", 6, 15, 15000),
		("Lada", "Niva", 20, 50, 10000),
		("Yugo", "Coral", 45, 50, 12000);

INSERT INTO Kupac (Ime, Prezime, BrLK, BrKupljenih)
VALUES ("Zoran", "Milicevic", 12345678, 2),
		("Cvijen", "Peranovic", 44984949, 1),
		("Ivana", "Stjepanovic", 94894949, 1),
		("Dusan", "Bobicic", 449484949, 1);
		
INSERT INTO Dobavljac (Naziv, BrDobavljenih)
VALUES ("YugoMotors", 30),
		("SerbiaCarImport", 20),
		("BelgradeImport", 10);

INSERT INTO Automobil (RegBr, IdM)
VALUES (48494984, 1),
		(123423423, 1),
		(4849984, 2),
		(21312312, 2),
		(142314124, 3),
		(1434124, 3),
		(134123, 4),
		(4123412, 4),
		(2413414123, 5),
		(1434131, 5),
		(41234134, 6),
		(4134115, 6);
		
INSERT INTO Kupovina(IdA, IdK, DatumVrijeme, Cijena)
VALUES (5, 1, '2018-06-23', 40000),	
		(7, 1, '2018-04-14', 70000),
		(1, 3, '2017-06-15', 25000),
		(11, 2, '2015-02-12', 300),
		(9, 4, '2016-03-13', 8000);
		
INSERT INTO Nabavka (IdA, IdD, DatumVrijeme, Cijena)
VALUES (1, 2, '2010-01-01', 30000),
		(2, 2, '2010-01-01', 30000),
		(3, 2, '2010-01-01', 30000),
		(4, 2, '2010-01-01', 30000),
		(5, 3, '2013-01-01', 20000),
		(6, 3, '2013-01-01', 20000),
		(7, 3, '2013-01-01', 20000),
		(8, 3, '2013-01-01', 20000),
		(9, 1, '2000-02-01', 4000),
		(10, 1, '2000-02-01', 4000),
		(11, 1, '2000-02-01', 4000),
		(12, 1, '2000-02-01', 4000);
		
DELETE FROM Nabavka