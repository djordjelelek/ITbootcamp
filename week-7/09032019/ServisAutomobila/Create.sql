CREATE TABLE Dobavljac(
	Id INTEGER PRIMARY KEY ,
	Naziv TEXT,
	BrDobavljenih INTEGER
	);
	
CREATE TABLE Model(
	Id INTEGER PRIMARY KEY,
	Marka TEXT,
	Model TEXT,
	BrProdatih INTEGER,
	BrNabavljenih INTEGER,
	Profit REAL
	);
	
CREATE TABLE Automobil(
	Id INTEGER PRIMARY KEY,
	RegBr INTEGER,
	IdM INTEGER
	);
	
CREATE TABLE Nabavka(
	IdA INTEGER,
	IdD INTEGER,
	DatumVrijeme date,
	Cijena REAL
	);
	
CREATE TABLE Kupac(
	Id INTEGER PRIMARY KEY,
	Ime TEXT,
	Prezime TEXT,
	BrLK INTEGER,
	BrKupljenih INTEGER
	);
	
CREATE TABLE Kupovina(
	IdA INTEGER,
	IdK INTEGER,
	DatumVrijeme date,
	Cijena REAL
	);	

