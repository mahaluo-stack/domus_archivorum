USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_genera_prehensionis;
CREATE TABLE nexuum.disciplina_genera_prehensionis
(
    disciplina_genera_prehensionis_identitas INT IDENTITY PRIMARY KEY,
    disciplinae_identitas                    INT NOT NULL,
    genera_prehensionis_identitas            INT NOT NULL,
    creatio                                  DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_genera_prehensionis_clavis_primaria PRIMARY KEY (disciplinae_identitas, genera_prehensionis_identitas),
    CONSTRAINT disciplina_genera_prehensionis_disciplinae_externae FOREIGN KEY (disciplinae_identitas) REFERENCES ars_disciplina.disciplinarum.disciplinae (disciplinae_identitas),
    CONSTRAINT disciplina_genera_prehensionis_genera_prehensionis_externae FOREIGN KEY (genera_prehensionis_identitas) REFERENCES ars_disciplina.prehensionum.genera_prehensionis (genera_prehensionis_identitas)
);