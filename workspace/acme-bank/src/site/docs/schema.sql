
CREATE DATABASE acme_bank_products;

CREATE TABLE card_holders (ID INTEGER NOT NULL PRIMARY KEY,
firstname VARCHAR,
lastname VARCHAR,
doc_type VARCHAR,
doc_number VARCHAR
);

insert into card_holders (ID, firstname, lastname, doc_type, doc_number)
values (680000, 'JAIME', 'CASTILLO RUBIO', 'P', 'B-07897876');
insert into card_holders (ID, firstname, lastname, doc_type, doc_number)
values (680001, 'FRIDA', 'DEL ARCIPRETE DE ROTTMAN', 'P', 'X9353678');
insert into card_holders (ID, firstname, lastname, doc_type, doc_number)
values (680002, 'RAFAEL', 'LOPEZ MELUS', 'D', '02879328L');
insert into card_holders (ID, firstname, lastname, doc_type, doc_number)
values (680003, 'ELENA', 'CHAVES TORRES', 'D', '60651927F');


CREATE TABLE cards (ID INTEGER NOT NULL PRIMARY KEY,
card_holder INTEGER NOT NULL REFERENCES card_holders(ID),
pan CHAR(16) NOT NULL,
cct CHAR(1) NOT NULL
);

INSERT INTO cards (ID, card_holder, pan, cct)
values (670000001,680003,'4929566256591900','C');
INSERT INTO cards (ID, card_holder, pan, cct)
values (670000002,680003,'4556070498737009','C');
INSERT INTO cards (ID, card_holder, pan, cct)
values (670000003,680003,'5516201939963138','C');
INSERT INTO cards (ID, card_holder, pan, cct)
values (670000004,680003,'2720996926207709','C');
INSERT INTO cards (ID, card_holder, pan, cct)
values (670000005,680002,'5568615979589106','C');
INSERT INTO cards (ID, card_holder, pan, cct)
values (670000006,680001,'4844859342474971','E');
INSERT INTO cards (ID, card_holder, pan, cct)
values (670000007,680001,'4175001005096481','E');
INSERT INTO cards (ID, card_holder, pan, cct)
values (670000008,680000,'4917723716308474','E');
INSERT INTO cards (ID, card_holder, pan, cct)
values (670000009,680000,'349996088554521','C');
INSERT INTO cards (ID, card_holder, pan, cct)
values (670000010,680000,'344448665797516','C');

DO $$
BEGIN
  CREATE USER  acme WITH PASSWORD 'acme' CREATEDB;
  EXCEPTION WHEN OTHERS THEN
  RAISE NOTICE 'not creating role acme -- it already exists';
END
$$;

GRANT ALL PRIVILEGES ON DATABASE acme_bank_products TO PUBLIC;
GRANT ALL PRIVILEGES ON TABLE card_holders TO acme;
GRANT ALL PRIVILEGES ON TABLE cards TO acme;
	
