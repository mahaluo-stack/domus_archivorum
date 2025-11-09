USE ars_disciplina;

DROP TABLE IF EXISTS disciplinarum.disciplina_variationes;
CREATE TABLE disciplinarum.disciplina_variationes
(
    disciplina_variationes_identitas INT IDENTITY PRIMARY KEY,
    nomen_variationis                VARCHAR(50) NOT NULL,
    creatio                          DATETIME2(0) DEFAULT SYSDATETIME()
);