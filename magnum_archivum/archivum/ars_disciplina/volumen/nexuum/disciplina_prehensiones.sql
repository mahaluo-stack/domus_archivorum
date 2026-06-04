USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_prehensiones;
CREATE TABLE nexuum.disciplina_prehensiones
(
    disciplinae_identitas  INT NOT NULL,
    prehensiones_identitas INT NOT NULL,
    creatio                DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_prehensiones_clavis_primaria PRIMARY KEY (disciplinae_identitas, prehensiones_identitas)
);