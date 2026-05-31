USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_motus;
CREATE TABLE nexuum.disciplina_motus
(
    disciplinae_identitas INT NOT NULL,
    motus_identitas       INT NOT NULL,
    creatio               DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_motus_clavis_primaria PRIMARY KEY (disciplinae_identitas, motus_identitas)
);