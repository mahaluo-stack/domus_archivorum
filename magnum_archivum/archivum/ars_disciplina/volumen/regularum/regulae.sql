USE ars_disciplina;

DROP TABLE IF EXISTS regularum.regulae;
CREATE TABLE regularum.regulae
(
    regulae_identitas INT IDENTITY PRIMARY KEY,
    nomen_regulae     VARCHAR(50)   NOT NULL,
    genus_regulae     VARCHAR(10)   NOT NULL,
    descriptio        VARCHAR(4000) NULL,
    creatio           DATETIME2(0) DEFAULT SYSDATETIME(),
    CONSTRAINT nomen_regulae UNIQUE (nomen_regulae)
);