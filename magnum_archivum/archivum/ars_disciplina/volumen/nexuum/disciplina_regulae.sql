USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_regulae;
CREATE TABLE nexuum.disciplina_regulae
(
    disciplinae_identitas INT NOT NULL,
    regulae_identitas     INT NOT NULL,
    creatio               DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_regulae_clavis_primaria PRIMARY KEY (disciplinae_identitas, regulae_identitas)
);