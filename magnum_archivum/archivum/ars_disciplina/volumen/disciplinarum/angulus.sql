USE ars_disciplina;

DROP TABLE IF EXISTS disciplinarum.angulus;
CREATE TABLE disciplinarum.angulus
(
    angulus_identitas INT IDENTITY PRIMARY KEY,
    angulus           FLOAT NOT NULL UNIQUE,
    creatio           DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT angulus_unicum UNIQUE (angulus)
);