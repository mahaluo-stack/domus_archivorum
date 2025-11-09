USE ars_disciplina
GO

CREATE OR ALTER PROCEDURE disciplinarum.adfero_genera_prehensionis @via_tabula VARCHAR(4000)
AS
BEGIN
    BEGIN TRANSACTION
        SET NOCOUNT ON;

        DECLARE @tabula VARCHAR(MAX) = @via_tabula + '\disciplinarum\genera_prehensionis.csv';
        DECLARE @scriptum NVARCHAR(MAX);

        DROP TABLE IF EXISTS #gradus_genera_prehensionis;
        CREATE TABLE #gradus_genera_prehensionis
        (
            nomen_genus_prehensionis VARCHAR(50) NOT NULL
        );

        SET @scriptum = N'
        BULK INSERT #gradus_genera_prehensionis
        FROM ''' + @tabula + N'''
        WITH
        (
            FIRSTROW = 2,
            FIELDTERMINATOR = '';'',
            ROWTERMINATOR = ''\n'',
            TABLOCK,
            KEEPNULLS
        );';

        EXEC sp_executesql @scriptum;

        INSERT INTO disciplinarum.genera_prehensionis(nomen_genus_prehensionis)
        SELECT ggp.nomen_genus_prehensionis
        FROM #gradus_genera_prehensionis ggp;

        DROP TABLE #gradus_genera_prehensionis;
    COMMIT TRANSACTION;
END
GO