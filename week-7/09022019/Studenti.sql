--1. Ispisati koliko kurseva postoji na svakom odseku
SELECT o.Naziv, count(*)
FROM Kurs k, Odsek o
WHERE k.SifO = o.SifO
GROUP BY k.SifO

--2. Ispisati imena kursa koji pohadja vise od 3 studenta. (koristiti group by)
SELECT k.Naziv
FROM Kurs k, Raspored r, Pohadja p
WHERE k.SifK=r.SifK AND r.SifR = p.SifR 
Group By k.Naziv   
having sum(p.SifS)>3

--3. Ispisati srednji broj studenata na kursevima.
SELECT avg (a)
FROM 
(SELECT sum(r.BrPrijaveljenih) as "a"
from Raspored r
group by r.SifK)

--4. Ispisati imena kurseva koje pohadja student sa sifrom 1.
SELECT k.Naziv
FROM Pohadja p, Raspored r, Kurs k
WHERE p.SifS = 1 and p.SifR = r.SifR AND r.SifK = k.SifK

--5. Ispisati imena studenata koji pohadja vise od 2 kursa.
SELECT s.Ime, count(p.SifS)as "Broj predmeta (vise od dva)"
FROM Student s, Pohadja p
WHERE s.SifS = p.SifS 
GROUP BY p.SifS
HAVING count(p.SifS)> 2

--6. Ispisati imena svih studenata koji imaju predavanja u ucionici 111 sa sifrom na dan Pon. 
SELECT s.Ime
FROM Pohadja p, Raspored r, Student s
WHERE r.Dan = "Pon" AND r.SifU = 111 AND r.SifR = p.SifR AND p.SifS = s.SifS
GROUP by s.Ime

--7. Ispisati ime kursa koji predaje profesor sa sifrom 7 a koji pohadja najveci broj studenata.
SELECT k.Naziv, max(r.BrPrijaveljenih) as "Maksimalni broj prijavljenih" 
FROM Raspored r, Kurs k
WHERE r.SifK = k.SifK and r.SifP = 7 and 
	r.BrPrijaveljenih = 
		(SELECT max(r.BrPrijaveljenih)
		FROM Raspored r
		WHERE r.SifP = 7)
		
--8. Ispisati imena svih kurseva koji su preduslov kursu sa sifrom 4. 
--(Tabela preduslov ima 2 strana kljuca koji oba referisu na tabelu Kurs, 
--strani kljuc SifKP je kurs koji je preduslov kursu sa sifrom SifK)
SELECT k.Naziv 
FROM Kurs k, Preduslov p
WHERE k.SifK = p.SifKP and p.SifK = 4 

--9. Ispisati koliko kurseva svaki kurs ima kao preduslov.
--(koristiti group by) Naziv kursa - broj kurseva koji su mu preduslov
SELECT k.Naziv, count(p.SifK) as "Broj predmeta koji su preduslov"  
FROM Kurs k, Preduslov p
WHERE k.SifK = p.SifK
GROUP by p.SifK
--vidjeti opet

--10.Za svakog profesora koliko studenata slusa njegovo predavanje na dan Pon.
--Ime - broj studenata (koristiti group by)
SELECT p.Ime, r.BrPrijaveljenih as "Broj Studenata koji slusaju predmet"
FROM Profesor p, Raspored r
WHERE p.SifP = r.SifP and r.Dan = "Pon"
GROUP BY r.SifP 



 

