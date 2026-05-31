USE ars_disciplina
GO

CREATE OR ALTER PROCEDURE classificationum.adfero_lateralis @via_tabula VARCHAR(4000)
AS
BEGIN
    BEGIN TRANSACTION
        SET NOCOUNT ON;

        DECLARE @tabula VARCHAR(MAX) = @via_tabula + '\classificationum\lateralis.csv';
        DECLARE @scriptum NVARCHAR(MAX);

        DROP TABLE IF EXISTS #gradus_lateralis;
        CREATE TABLE #gradus_lateralis
        (
            nomen_lateralis VARCHAR(50)   NOT NULL
        );

        SET @scriptum = N'
        BULK INSERT #gradus_lateralis
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

        INSERT INTO classificationum.lateralis(nomen_lateralis)
        SELECT gld.nomen_lateralis
        FROM #gradus_lateralis gld;

        DROP TABLE #gradus_lateralis;
    COMMIT TRANSACTION;
END
GO