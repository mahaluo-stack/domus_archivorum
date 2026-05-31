USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_prehensiones;
CREATE TABLE nexuum.disciplina_prehensiones
(
    disciplinae_identitas  INT NOT NULL,
    prehensiones_identitas INT NOT NULL,
    creatio                DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_prehensiones_clavis_primaria PRIMARY KEY (disciplinae_identitas, prehensiones_identitas),
    CONSTRAINT disciplina_prehensiones_disciplinae_externae FOREIGN KEY (disciplinae_identitas) REFERENCES ars_disciplina.disciplinarum.disciplinae (disciplinae_identitas),
    CONSTRAINT disciplina_prehensiones_prehensiones_externae FOREIGN KEY (prehensiones_identitas) REFERENCES ars_disciplina.prehensionum.prehensiones (prehensiones_identitas)
);