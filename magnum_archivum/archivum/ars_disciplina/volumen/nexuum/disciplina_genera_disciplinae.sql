USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_genera_disciplinae;
CREATE TABLE nexuum.disciplina_genera_disciplinae
(
    disciplinae_identitas        INT NOT NULL,
    genera_disciplinae_identitas INT NOT NULL,
    creatio                      DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_genera_disciplinae_clavis_primaria PRIMARY KEY (disciplinae_identitas, genera_disciplinae_identitas)
);