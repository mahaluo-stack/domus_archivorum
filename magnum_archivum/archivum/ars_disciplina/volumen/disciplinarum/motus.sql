USE ars_disciplina;

DROP TABLE IF EXISTS disciplinarum.motus;
CREATE TABLE disciplinarum.motus
(
    motus_identitas INT IDENTITY PRIMARY KEY,
    nomen_motus     VARCHAR(50)   NOT NULL,
    descriptio      VARCHAR(4000) NULL,
    creatio         DATETIME2(0) DEFAULT SYSDATETIME()
);