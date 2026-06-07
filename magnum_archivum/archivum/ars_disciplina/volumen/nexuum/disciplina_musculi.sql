USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_musculi;
CREATE TABLE nexuum.disciplina_musculi
(
    disciplinae_identitas  INT NOT NULL,
    musculi_identitas INT NOT NULL,
    creatio                DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_musculi_clavis_primaria PRIMARY KEY (disciplinae_identitas, musculi_identitas)
);