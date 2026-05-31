USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_lateralitates;
CREATE TABLE nexuum.disciplina_lateralitates
(
    disciplinae_identitas              INT NOT NULL,
    lateralis_identitas                INT NOT NULL,
    creatio                            DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_lateralitates_clavis_primaria PRIMARY KEY (disciplinae_identitas, lateralis_identitas)
);