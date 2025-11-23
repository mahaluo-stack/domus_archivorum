USE ars_disciplina;

DROP TABLE IF EXISTS classificationum.modus_oneris;
CREATE TABLE classificationum.modus_oneris
(
    modus_oneris_identitas INT IDENTITY PRIMARY KEY,
    nomen_modus_oneris     VARCHAR(50) NOT NULL,
    creatio                DATETIME2(0) DEFAULT SYSDATETIME()
);