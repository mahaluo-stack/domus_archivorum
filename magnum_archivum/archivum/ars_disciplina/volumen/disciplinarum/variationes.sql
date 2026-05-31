USE ars_disciplina;

DROP TABLE IF EXISTS disciplinarum.variationes;
CREATE TABLE disciplinarum.variationes
(
    variationes_identitas INT IDENTITY PRIMARY KEY,
    nomen_variationis     VARCHAR(50) NOT NULL,
    creatio               DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT nomen_variationis_unicum UNIQUE (nomen_variationis)
);