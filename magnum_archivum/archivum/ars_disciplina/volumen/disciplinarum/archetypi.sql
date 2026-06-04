USE ars_disciplina;

DROP TABLE IF EXISTS disciplinarum.archetypi;
CREATE TABLE disciplinarum.archetypi
(
    archetypus_identitas INT IDENTITY PRIMARY KEY,
    nomen_archetypi      VARCHAR(50)   NOT NULL,
    descriptio           VARCHAR(4000) NULL,
    creatio              DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT nomen_archetypi UNIQUE (nomen_archetypi)
);