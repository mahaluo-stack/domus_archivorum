USE ars_disciplina
GO

CREATE OR ALTER PROCEDURE disciplinarum.adfero_angulus @via_tabula VARCHAR(4000)
AS
BEGIN
    BEGIN TRANSACTION
        SET NOCOUNT ON;

        DECLARE @tabula VARCHAR(MAX) = @via_tabula + '\disciplinarum\angulus.csv';
        DECLARE @scriptum NVARCHAR(MAX);

        DROP TABLE IF EXISTS #gradus_angulus;
        CREATE TABLE #gradus_angulus
        (
            angulus FLOAT NOT NULL
        );

        SET @scriptum = N'
        BULK INSERT #gradus_angulus
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

        INSERT INTO disciplinarum.angulus(angulus)
        SELECT ga.angulus
        FROM #gradus_angulus ga;

        DROP TABLE #gradus_angulus;
    COMMIT TRANSACTION;
END
GO