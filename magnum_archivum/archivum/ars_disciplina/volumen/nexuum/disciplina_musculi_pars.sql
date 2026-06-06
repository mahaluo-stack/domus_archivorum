USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_musculi_pars;
CREATE TABLE nexuum.disciplina_musculi_pars
(
    disciplinae_identitas  INT NOT NULL,
    musculi_pars_identitas INT NOT NULL,
    creatio                DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_musculi_pars_clavis_primaria PRIMARY KEY (disciplinae_identitas, musculi_pars_identitas)
);