USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_genera_prehensionis;
CREATE TABLE nexuum.disciplina_genera_prehensionis
(
    disciplinae_identitas                    INT NOT NULL,
    genera_prehensionis_identitas            INT NOT NULL,
    creatio                                  DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_genera_prehensionis_clavis_primaria PRIMARY KEY (disciplinae_identitas, genera_prehensionis_identitas)
);