USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_archetypi;
CREATE TABLE nexuum.disciplina_archetypi
(
    disciplinae_identitas INT NOT NULL,
    archetypus_identitas  INT NOT NULL,
    creatio               DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_archetypi_clavis_primaria PRIMARY KEY (disciplinae_identitas, archetypus_identitas)
);