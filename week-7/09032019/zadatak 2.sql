--1. Izdvojiti podatke o svim predmetima.
SELECT * 
from predmet;

--2. Izdvojiti podatke o svim studentima rođenim u Beogradu.
SELECT *
FROM dosije
WHERE mesto_rodjenja = "Beograd";

--3.Izdvojiti mesta u kojima su rođeni studenti.
SELECT DISTINCT (mesto_rodjenja)
FROM dosije
WHERE mesto_rodjenja is not NULL;

--4. Izdvojiti nazive predmeta koji imaju više od 6 bodova.
SELECT *
FROM predmet
WHERE bodovi>6;

--5. Izdvojiti šifre i nazive predmeta koji imaju između 8 i 15 bodova.
SELECT sifra, naziv
FROM predmet
WHERE bodovi BETWEEN 8 and 15;

--6. Izdvojiti podatke o ispitima na kojima student ima 81, 76 ili 59 bodova.
SELECT *
FROM ispit
WHERE bodovi=81 or bodovi=76 or bodovi=59;

--7. Izdvojiti podatke o ispitima na kojima student nema 81, 76 ili 59 bodova.
SELECT *
FROM ispit
WHERE bodovi!=81 AND bodovi!=76 AND bodovi!=59;

--8. Izdvojiti nazive predmeta i njihovu cenu za samofinansirajuće studente izraženu u dinarima. 
--Jedan bod košta 1500 dinara.
SELECT naziv, bodovi, 1500 as "Cijena boda"
FROM predmet;

--9. Izdvojiti nazive predmeta i njihovu cenu za samofinansirajuće studente izraženu u dinarima. 
--Jedan bod košta 1500 dinara. Između kolone naziv i kolone cena dodati 
--kolonu u kojoj će za svaku vrstu biti ispisano Cena u dinarima.
SELECT naziv, bodovi, bodovi*1500 as "Cijena ispita", 1500 as "Cijena boda"
FROM predmet;

--10.Prikazati podatke o predmetima. Rezultat urediti po bodovima
      -- a. u rastućem poretku;
      -- b. u opadajućem poretku;
      -- c. u rastućem poretku i po nazivu u opadajućem poretku.
SELECT *
FROM predmet
ORDER by bodovi;

SELECT *
FROM predmet
ORDER by bodovi DESC;

SELECT *
FROM predmet
ORDER by bodovi, naziv DESC;

--12. Za svaki rok koji je održan u 2015. godini i u kome su svi polagani ispiti i položeni, 
--tj. nema ispita koji nije položen, izdvojiti oznaku roka, 
--broj položenih ispita u tom roku i broj studenata koji su položili ispite u tom roku.
SELECT oznaka_roka, count(DISTINCT id_predmeta) as "Broj polozenih ispita", 
					count(DISTINCT indeks) as "Broj studenata koji su polozili ispit"
FROM ispit
WHERE godina_roka = 2015 
GROUP BY oznaka_roka
HAVING  min(ocena) > 5;

--13. Ispisati Ime i prezime studenata koji su polozili ispit iz predmeta sa sifrom 1001 , 
--2015. u roku jan
SELECT ime, prezime
FROM dosije d, ispit i
WHERE d.indeks = i.indeks AND i.id_predmeta = 1001 AND i.godina_roka = 2015 AND i.oznaka_roka = "jan";

--14. Ispisati prosecan broj poena osvojenih na ispitu iz predmeta sa sifrom 1021, 
--za 2015. godinu za sve rokove osim apr
SELECT avg (i.bodovi) as "Prosjecan broj poena"
FROM ispit i
WHERE i.id_predmeta = 1021 AND i.godina_roka = 2015 AND i.oznaka_roka != "apr";

--15.Ispisati broj studenata koji su polozili bilo koji ispit
--(ako je jedan student polozio vise ispita,racunati ga samo jednom)
SELECT d.ime, d.prezime
FROM dosije d, ispit i
WHERE i.indeks = d.indeks AND i.ocena > 5
GROUP BY i.indeks;

-- 16. Ispisati prosecan broj poena studenta sa brojem indeksa 20130023
SELECT avg (bodovi) as " Prosjecan broj poena"
FROM ispit
WHERE indeks = 20130023;

--17. Ispisati prosecnu ocenu studenata za rok jan 2015.
SELECT avg (bodovi) as " Prosjecna ocjena za januar"
FROM ispit
WHERE godina_roka = 2015 AND oznaka_roka = "jan";

--18. Ispisati nazive onih predemeta koji nose 6 poena i za njih je odrzan ispit u januaru 2015.
SELECT p.naziv
FROM predmet p, ispit i
WHERE p.id_predmeta = p.id_predmeta AND p.bodovi = 6 AND i.oznaka_roka = "jan"
GROUP BY naziv;