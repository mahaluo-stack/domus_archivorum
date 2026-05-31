USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_anguli;
CREATE TABLE nexuum.disciplina_anguli
(
    disciplinae_identitas       INT NOT NULL,
    angulus_identitas           INT NOT NULL,
    creatio                     DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_anguli_clavis_primaria PRIMARY KEY (disciplinae_identitas, angulus_identitas)
);