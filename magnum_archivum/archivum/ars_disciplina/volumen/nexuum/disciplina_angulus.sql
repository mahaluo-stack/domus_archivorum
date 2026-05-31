USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_anguli;
CREATE TABLE nexuum.disciplina_anguli
(
    disciplina_anguli_identitas INT IDENTITY PRIMARY KEY,
    disciplinae_identitas       INT NOT NULL,
    angulus_identitas           INT NOT NULL,
    creatio                     DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_anguli_clavis_primaria PRIMARY KEY (disciplinae_identitas, angulus_identitas),
    CONSTRAINT disciplina_anguli_disciplinae_externae FOREIGN KEY (disciplinae_identitas) REFERENCES ars_disciplina.disciplinarum.disciplinae (disciplinae_identitas),
    CONSTRAINT disciplina_anguli_angulus_externae FOREIGN KEY (angulus_identitas) REFERENCES ars_disciplina.disciplinarum.angulus (angulus_identitas)
);