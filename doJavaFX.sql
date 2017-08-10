CREATE DATABASE FX;
use FX;
CREATE TABLE employee (
id_employee Integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
firstName_employee VARCHAR(15) NOT NULL,
lastName_employee VARCHAR(25) NOT NULL,
gross_salary_employee VARCHAR(20) NOT NULL
);
drop table employee;

INSERT INTO employee VALUES (NULL, 'admin', 'admin123', '2000');
INSERT INTO employee VALUES (NULL, 'Bartosz', 'Kowalski','3000');
INSERT INTO employee VALUES (NULL, 'Kamil', 'Nowak','4000');
INSERT INTO employee VALUES (NULL, 'Marcel', 'Kaczynski','5000');
INSERT INTO employee VALUES (NULL, 'Maria', 'Kwasniewski','6000');
INSERT INTO employee VALUES (NULL, 'Wojciech', 'Tusk','7000');
INSERT INTO employee VALUES (10, 'Michalina', 'Macierewicz','8000');
INSERT INTO employee VALUES (11, 'Grzegorz', 'Kopacz','9000');
INSERT INTO employee VALUES (12, 'Zenon', 'Nawalka','10000');
SELECT * FROM employee;

INSERT INTO login VALUES (NULL,'admin','admin123','admin');
INSERT INTO login VALUES (NULL,'BartoszK','bartek','pracownik');
INSERT INTO login VALUES (NULL,'KamilN','kamil','pracownik');
INSERT INTO login VALUES (NULL,'MarcelK','marcel','pracownik');
INSERT INTO login VALUES (NULL,'MariaK','maria','pracownik');
INSERT INTO login VALUES (NULL,'WojciechT','wojciech','pracownik');
INSERT INTO login VALUES (NULL,'MichalinaM','michalina','pracownik');
INSERT INTO login VALUES (NULL,'GrzegorzK','grzegorz','pracownik');
INSERT INTO login VALUES (NULL,'ZenonN','zenon','pracownik');
select * from login;
select * from login where users= 'admin';

CREATE TABLE login (
id_login INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
users VARCHAR(50) NOT NULL,
passwords VARCHAR(50) NOT NULL,
access VARCHAR(20) NOT NULL
);


