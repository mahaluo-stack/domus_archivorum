USE ars_disciplina;

DROP TABLE IF EXISTS classificationum.lateralis;
CREATE TABLE classificationum.lateralis
(
    lateralis_identitas INT IDENTITY PRIMARY KEY,
    nomen_lateralis     VARCHAR(50) NOT NULL,
    creatio             DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT nomen_lateralis_unicum UNIQUE (nomen_lateralis)
);