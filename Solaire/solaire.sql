-- Creation de la table Salle
CREATE TABLE Salle (
    idSalle SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL
);
insert into Salle(nom) values('S1 Info');

-- Creation de la table Presence
CREATE TABLE Presence (
    date DATE,
    idSalle INT REFERENCES Salle(idSalle),
    type INT,
    nbEleve INT,
    consommation DOUBLE PRECISION
);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-01',1,1,300,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-01',1,5,280,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-02',1,1,250,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-02',1,5,240,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-03',1,1,220,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-03',1,5,210,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-06',1,1,320,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-06',1,5,330,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-07',1,1,300,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-07',1,5,290,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-08',1,1,300,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-08',1,5,280,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-09',1,1,250,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-09',1,5,240,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-10',1,1,220,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-10',1,5,210,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-13',1,1,320,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-13',1,5,330,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-14',1,1,300,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-14',1,5,290,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-15',1,1,300,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-15',1,5,280,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-16',1,1,250,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-16',1,5,240,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-17',1,1,220,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-17',1,5,210,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-20',1,1,320,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-20',1,5,330,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-21',1,1,300,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-21',1,5,290,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-22',1,1,300,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-22',1,5,280,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-23',1,1,250,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-23',1,5,240,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-24',1,1,220,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-24',1,5,210,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-27',1,1,320,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-27',1,5,330,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-28',1,1,300,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-28',1,5,290,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-29',1,1,300,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-29',1,5,280,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-30',1,1,250,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-11-30',1,5,240,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-01',1,1,220,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-01',1,5,210,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-04',1,1,320,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-04',1,5,330,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-05',1,1,300,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-05',1,5,290,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-06',1,1,300,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-06',1,5,280,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-07',1,1,250,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-07',1,5,240,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-08',1,1,220,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-08',1,5,210,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-11',1,1,320,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-11',1,5,330,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-12',1,1,300,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-12',1,5,290,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-13',1,1,300,60);
insert into presence(date,idSalle,type,nbEleve,consommation) values('2023-12-13',1,5,280,60);

-- Creation de la table Batterie
CREATE TABLE Batterie (
    idBatterie SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    puissance DOUBLE PRECISION
);
insert into Batterie(nom,puissance) values('vista',19200);

-- Creation de la table Panneau
CREATE TABLE Panneau (
    idPanneau SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL
);
insert into Panneau(nom) values('secteur 1');

-- Creation de la table Solaire
CREATE TABLE Solaire (
    idSolaire SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    puissance DOUBLE PRECISION
);
insert into Solaire(nom,puissance) values('sll',25000);

-- Creation de la table PanneauSolaire
CREATE TABLE PanneauSolaire (
    idPanneau INT REFERENCES Panneau(idPanneau),
    idSolaire INT REFERENCES Solaire(idSolaire)
);
insert into PanneauSolaire(idPanneau,idSolaire) values(1,1);

-- Creation de la table PanneauBatterie
CREATE TABLE PanneauBatterie (
    idPanneau INT REFERENCES Panneau(idPanneau),
    idBatterie INT REFERENCES Batterie(idBatterie)
);
insert into PanneauBatterie(idPanneau,idBatterie) values(1,1);

-- Creation de la table PanneauSalle
CREATE TABLE PanneauSalle (
    idPanneau INT REFERENCES Panneau(idPanneau),
    idSalle INT REFERENCES Salle(idSalle)
);
insert into PanneauSalle(idPanneau,idSalle) values(1,1);
-- Creation de la table Luminosite
CREATE TABLE Luminosite (
    idLuminosite SERIAL PRIMARY KEY,
    date DATE,
    puissance DOUBLE PRECISION,
    heure INT
);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-01',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-01',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-01',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-01',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-01',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-01',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-01',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-01',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-02',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-02',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-02',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-02',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-02',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-02',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-02',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-02',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-03',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-03',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-03',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-03',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-03',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-03',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-03',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-03',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-06',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-06',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-06',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-06',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-06',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-06',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-06',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-06',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-07',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-07',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-07',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-07',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-07',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-07',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-07',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-07',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-08',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-08',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-08',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-08',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-08',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-08',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-08',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-08',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-09',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-09',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-09',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-09',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-09',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-09',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-09',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-09',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-10',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-10',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-10',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-10',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-10',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-10',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-10',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-10',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-13',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-13',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-13',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-13',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-13',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-13',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-13',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-13',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-14',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-14',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-14',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-14',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-14',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-14',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-14',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-14',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-15',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-15',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-15',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-15',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-15',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-15',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-15',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-15',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-16',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-16',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-16',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-16',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-16',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-16',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-16',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-16',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-17',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-17',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-17',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-17',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-17',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-17',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-17',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-17',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-20',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-20',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-20',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-20',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-20',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-20',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-20',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-20',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-21',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-21',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-21',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-21',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-21',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-21',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-21',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-21',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-22',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-22',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-22',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-22',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-22',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-22',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-22',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-22',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-23',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-23',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-23',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-23',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-23',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-23',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-23',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-23',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-24',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-24',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-24',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-24',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-24',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-24',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-24',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-24',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-27',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-27',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-27',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-27',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-27',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-27',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-27',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-27',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-28',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-28',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-28',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-28',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-28',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-28',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-28',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-28',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-29',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-29',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-29',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-29',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-29',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-29',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-29',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-29',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-30',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-30',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-30',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-30',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-30',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-30',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-30',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-11-30',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-01',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-01',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-01',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-01',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-01',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-01',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-01',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-01',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-04',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-04',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-04',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-04',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-04',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-04',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-04',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-04',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-05',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-05',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-05',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-05',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-05',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-05',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-05',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-05',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-06',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-06',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-06',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-06',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-06',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-06',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-06',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-06',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-07',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-07',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-07',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-07',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-07',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-07',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-07',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-07',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-08',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-08',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-08',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-08',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-08',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-08',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-08',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-08',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-11',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-11',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-11',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-11',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-11',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-11',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-11',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-11',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-12',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-12',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-12',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-12',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-12',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-12',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-12',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-12',17,4);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-13',8,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-13',9,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-13',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-13',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-13',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-13',15,7);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-13',16,6);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2023-12-13',17,4);

--a rechercher

INSERT INTO Luminosite (date,heure, puissance) VALUES ('2024-01-03',8,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2024-01-03',9,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2024-01-03',10,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2024-01-03',11,9);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2024-01-03',14,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2024-01-03',15,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2024-01-03',16,8);
INSERT INTO Luminosite (date,heure, puissance) VALUES ('2024-01-03',17,9);

-- Creation de la table Historique
CREATE TABLE Historique (
    idHistorique SERIAL PRIMARY KEY,
    heure INT,
    minute INT,
    date DATE,
    idPanneau INT
);
insert into Historique(date,heure,minute,idPanneau) values('2023-11-01',15,45,1);-- 73.6 --mercredi
insert into Historique(date,heure,minute,idPanneau) values('2023-11-02',16,30,1);--83.9 --jeudi
insert into Historique(date,heure,minute,idPanneau) values('2023-11-03',17,0,1);--92.6 --vendredi
insert into Historique(date,heure,minute,idPanneau) values('2023-11-06',15,0,1);-- 65.85 --lundi
insert into Historique(date,heure,minute,idPanneau) values('2023-11-07',15,40,1);--72.8 -- mardi
insert into Historique(date,heure,minute,idPanneau) values('2023-11-08',15,45,1);-- 73.6
insert into Historique(date,heure,minute,idPanneau) values('2023-11-09',16,29,1);--83.9
insert into Historique(date,heure,minute,idPanneau) values('2023-11-10',17,1,1);--92.6
insert into Historique(date,heure,minute,idPanneau) values('2023-11-13',15,2,1);-- 65.85
insert into Historique(date,heure,minute,idPanneau) values('2023-11-14',15,42,1);--72.8
insert into Historique(date,heure,minute,idPanneau) values('2023-11-15',15,43,1);-- 73.6
insert into Historique(date,heure,minute,idPanneau) values('2023-11-16',16,32,1);--83.9
insert into Historique(date,heure,minute,idPanneau) values('2023-11-17',17,3,1);--92.6
insert into Historique(date,heure,minute,idPanneau) values('2023-11-20',14,55,1);-- 65.85
insert into Historique(date,heure,minute,idPanneau) values('2023-11-21',15,35,1);--72.8
insert into Historique(date,heure,minute,idPanneau) values('2023-11-22',15,40,1);-- 73.6
insert into Historique(date,heure,minute,idPanneau) values('2023-11-23',16,24,1);--83.9
insert into Historique(date,heure,minute,idPanneau) values('2023-11-24',16,55,1);--92.6
insert into Historique(date,heure,minute,idPanneau) values('2023-11-27',15,4,1);-- 65.85
insert into Historique(date,heure,minute,idPanneau) values('2023-11-28',15,44,1);--72.8
insert into Historique(date,heure,minute,idPanneau) values('2023-11-29',15,49,1);-- 73.6
insert into Historique(date,heure,minute,idPanneau) values('2023-11-30',16,33,1);--83.9
insert into Historique(date,heure,minute,idPanneau) values('2023-12-01',17,06,1);--92.6
insert into Historique(date,heure,minute,idPanneau) values('2023-12-04',14,59,1);-- 65.85
insert into Historique(date,heure,minute,idPanneau) values('2023-12-05',15,39,1);--72.8
insert into Historique(date,heure,minute,idPanneau) values('2023-12-06',15,44,1);-- 73.6
insert into Historique(date,heure,minute,idPanneau) values('2023-12-07',16,28,1); --83.9
insert into Historique(date,heure,minute,idPanneau) values('2023-12-08',17,0,1); --92.6
insert into Historique(date,heure,minute,idPanneau) values('2023-12-11',15,46,1); -- 65.85
insert into Historique(date,heure,minute,idPanneau) values('2023-12-12',16,32,1); -- 69.4
insert into Historique(date,heure,minute,idPanneau) values('2023-12-13',17,1,1); -- 68.5

--2400.9/31 = 77.448

mercredi 3 janvier 2024 
9
9
9
9
8
8
8
9