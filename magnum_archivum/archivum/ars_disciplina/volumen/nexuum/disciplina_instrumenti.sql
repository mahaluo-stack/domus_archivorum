USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_instrumenti;
CREATE TABLE nexuum.disciplina_instrumenti
(
    disciplinae_identitas INT NOT NULL,
    instrumenta_identitas INT NOT NULL,
    creatio               DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_instrumenti_clavis_primaria PRIMARY KEY (disciplinae_identitas, instrumenta_identitas)
);