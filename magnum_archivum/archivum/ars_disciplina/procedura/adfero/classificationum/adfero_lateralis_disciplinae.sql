USE ars_disciplina
GO

CREATE OR ALTER PROCEDURE classificationum.adfero_lateralis_disciplinae @via_tabula VARCHAR(4000)
AS
BEGIN
    BEGIN TRANSACTION
        SET NOCOUNT ON;

        DECLARE @tabula VARCHAR(MAX) = @via_tabula + '\classificationum\lateralis_disciplinae.csv';
        DECLARE @scriptum NVARCHAR(MAX);

        DROP TABLE IF EXISTS #gradus_lateralis_disciplinae;
        CREATE TABLE #gradus_lateralis_disciplinae
        (
            nomen_lateralis_disciplinae VARCHAR(50)   NOT NULL
        );

        SET @scriptum = N'
        BULK INSERT #gradus_lateralis_disciplinae
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

        INSERT INTO classificationum.lateralis_disciplinae(nomen_lateralis_disciplinae)
        SELECT gld.nomen_lateralis_disciplinae
        FROM #gradus_lateralis_disciplinae gld;

        DROP TABLE #gradus_lateralis_disciplinae;
    COMMIT TRANSACTION;
END
GO