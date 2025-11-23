USE ars_disciplina;

DROP TABLE IF EXISTS classificationum.lateralis_disciplinae;
CREATE TABLE classificationum.lateralis_disciplinae
(
    lateralis_disciplinae_identitas INT IDENTITY PRIMARY KEY,
    nomen_lateralis_disciplinae     VARCHAR(50) NOT NULL,
    creatio                         DATETIME2(0) DEFAULT SYSDATETIME()
);