USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_variationes;
CREATE TABLE nexuum.disciplina_variationes
(
    disciplinae_identitas INT NOT NULL,
    variationes_identitas INT NOT NULL,
    creatio               DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_variationes_clavis_primaria PRIMARY KEY (disciplinae_identitas, variationes_identitas),
    CONSTRAINT disciplina_variationes_disciplinae_externae FOREIGN KEY (disciplinae_identitas) REFERENCES ars_disciplina.disciplinarum.disciplinae (disciplinae_identitas),
    CONSTRAINT disciplina_variationes_variationes_externae FOREIGN KEY (variationes_identitas) REFERENCES ars_disciplina.disciplinarum.variationes (variationes_identitas)
);