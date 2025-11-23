USE ars_disciplina
GO

CREATE OR ALTER PROCEDURE classificationum.adfero_genera_disciplinae @via_tabula VARCHAR(4000)
AS
BEGIN
    BEGIN TRANSACTION
        SET NOCOUNT ON;

        DECLARE @tabula VARCHAR(MAX) = @via_tabula + '\classificationum\genera_disciplinae.csv';
        DECLARE @scriptum NVARCHAR(MAX);

        DROP TABLE IF EXISTS #gradus_genera_disciplinae;
        CREATE TABLE #gradus_genera_disciplinae
        (
            nomen_genus_disciplinae VARCHAR(50) NOT NULL
        );

        SET @scriptum = N'
        BULK INSERT #gradus_genera_disciplinae
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

        INSERT INTO classificationum.genera_disciplinae(nomen_genus_disciplinae)
        SELECT ggd.nomen_genus_disciplinae
        FROM #gradus_genera_disciplinae ggd;

        DROP TABLE #gradus_genera_disciplinae;
    COMMIT TRANSACTION;
END
GO