USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_modi_oneris;
CREATE TABLE nexuum.disciplina_modi_oneris
(
    disciplinae_identitas            INT NOT NULL,
    modus_oneris_identitas           INT NOT NULL,
    creatio                          DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_modi_oneris_clavis_primaria PRIMARY KEY (disciplinae_identitas, modus_oneris_identitas)
);