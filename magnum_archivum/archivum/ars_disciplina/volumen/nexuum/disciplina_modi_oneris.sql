USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_modi_oneris;
CREATE TABLE nexuum.disciplina_modi_oneris
(
    disciplina_modi_oneris_identitas INT IDENTITY PRIMARY KEY,
    disciplinae_identitas            INT NOT NULL,
    modus_oneris_identitas           INT NOT NULL,
    creatio                          DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_modi_oneris_clavis_primaria PRIMARY KEY (disciplinae_identitas, modus_oneris_identitas),
    CONSTRAINT disciplina_modi_oneris_disciplinae_externae FOREIGN KEY (disciplinae_identitas) REFERENCES ars_disciplina.disciplinarum.disciplinae (disciplinae_identitas),
    CONSTRAINT disciplina_modi_oneris_modus_oneris_externae FOREIGN KEY (modus_oneris_identitas) REFERENCES ars_disciplina.classificationum.modus_oneris (modus_oneris_identitas)
);