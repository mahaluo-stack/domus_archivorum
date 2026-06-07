USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_musculi_regio;
CREATE TABLE nexuum.disciplina_musculi_regio
(
    disciplinae_identitas  INT NOT NULL,
    musculi_regio_identitas INT NOT NULL,
    creatio                DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_musculi_regio_clavis_primaria PRIMARY KEY (disciplinae_identitas, musculi_regio_identitas)
);