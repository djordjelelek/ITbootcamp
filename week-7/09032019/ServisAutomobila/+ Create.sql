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
	IdM INTEGER,
	FOREIGN KEY (IdM) REFERENCES Model(Id)
	);
	
CREATE TABLE Nabavka(
	IdA INTEGER,
	IdD INTEGER,
	DatumVrijeme date,
	Cijena REAL,
	FOREIGN KEY (IdA) REFERENCES Automobil(Id),
	FOREIGN KEY (IdD) REFERENCES Dobavljac(Id)
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
	Cijena REAL,
	FOREIGN KEY (IdA) REFERENCES Automobil(Id),
	FOREIGN KEY (IdK) REFERENCES Kupac(Id)
	)	

DROP TABLE Model

	