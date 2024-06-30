DROP DATABASE dokotera;

CREATE DATABASE dokotera;
\c dokotera

CREATE TABLE symptome(
    idSymptome serial PRIMARY KEY,
    nom TEXT
);

CREATE TABLE medicament(
    idMedicament serial PRIMARY KEY,
    nom TEXT,
    
);