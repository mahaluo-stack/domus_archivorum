USE ars_disciplina;

DROP TABLE IF EXISTS classificationum.genera_disciplinae;
CREATE TABLE classificationum.genera_disciplinae
(
    genera_disciplinae_identitas INT IDENTITY PRIMARY KEY,
    nomen_genus_disciplinae     VARCHAR(50)   NOT NULL,
    descriptio                  VARCHAR(4000) NULL,
    creatio                     DATETIME2(0) DEFAULT SYSDATETIME()
);