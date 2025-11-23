USE ars_disciplina
GO

CREATE OR ALTER PROCEDURE dbo.adfero_ordinata_volumina @via_tabula VARCHAR(4000)
AS
BEGIN
    EXECUTE musculorum.adfero_musculi_regio @via_tabula = @via_tabula;
    EXECUTE musculorum.adfero_musculi @via_tabula = @via_tabula;
    EXECUTE musculorum.adfero_musculi_pars @via_tabula = @via_tabula;

    EXECUTE instrumentorum.adfero_instrumenta @via_tabula = @via_tabula;
    EXECUTE instrumentorum.adfero_genus_instrumenti @via_tabula = @via_tabula;

    EXECUTE disciplinarum.adfero_angulus @via_tabula = @via_tabula;
    EXECUTE disciplinarum.adfero_disciplina_variationes @via_tabula = @via_tabula;
    EXECUTE disciplinarum.adfero_disciplinae @via_tabula = @via_tabula;
    EXECUTE disciplinarum.adfero_motus @via_tabula = @via_tabula;

    EXECUTE classificationum.adfero_genera_disciplinae @via_tabula = @via_tabula;
    EXECUTE classificationum.adfero_lateralis_disciplinae @via_tabula = @via_tabula;
    EXECUTE classificationum.adfero_modus_oneris @via_tabula = @via_tabula;

    EXECUTE prehensionum.adfero_genera_prehensionis @via_tabula = @via_tabula;
    EXECUTE prehensionum.adfero_prehensiones @via_tabula = @via_tabula;
END
GO