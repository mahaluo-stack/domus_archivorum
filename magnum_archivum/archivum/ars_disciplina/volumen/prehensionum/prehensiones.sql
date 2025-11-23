USE ars_disciplina;

DROP TABLE IF EXISTS prehensionum.prehensiones;
CREATE TABLE prehensionum.prehensiones
(
    prehensiones_identitas INT IDENTITY PRIMARY KEY,
    nomen_prehensionis     VARCHAR(50)   NOT NULL,
    descriptio             VARCHAR(4000) NULL,
    creatio                DATETIME2(0) DEFAULT SYSDATETIME()
);