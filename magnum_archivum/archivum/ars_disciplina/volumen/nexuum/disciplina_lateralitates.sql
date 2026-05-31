USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_lateralitates;
CREATE TABLE nexuum.disciplina_lateralitates
(
    disciplina_lateralitates_identitas INT IDENTITY PRIMARY KEY,
    disciplinae_identitas              INT NOT NULL,
    lateralis_identitas                INT NOT NULL,
    creatio                            DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_lateralitates_clavis_primaria PRIMARY KEY (disciplinae_identitas, lateralis_identitas),
    CONSTRAINT disciplina_lateralitates_disciplinae_externae FOREIGN KEY (disciplinae_identitas) REFERENCES ars_disciplina.disciplinarum.disciplinae (disciplinae_identitas),
    CONSTRAINT disciplina_lateralitates_lateralis_externae FOREIGN KEY (lateralis_identitas) REFERENCES ars_disciplina.classificationum.lateralis (lateralis_identitas)
);