USE ars_disciplina;

DROP TABLE IF EXISTS nexuum.disciplina_genera_instrumenti;
CREATE TABLE nexuum.disciplina_genera_instrumenti
(
    disciplinae_identitas   INT NOT NULL,
    nomen_genus_instrumenti INT NOT NULL,
    creatio                 DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT disciplina_genera_instrumenti_clavis_primaria PRIMARY KEY (disciplinae_identitas, nomen_genus_instrumenti)
);