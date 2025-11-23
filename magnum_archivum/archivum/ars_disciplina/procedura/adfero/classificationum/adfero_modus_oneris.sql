USE ars_disciplina
GO

CREATE OR ALTER PROCEDURE classificationum.adfero_modus_oneris @via_tabula VARCHAR(4000)
AS
BEGIN
    BEGIN TRANSACTION
        SET NOCOUNT ON;

        DECLARE @tabula VARCHAR(MAX) = @via_tabula + '\classificationum\modus_oneris.csv';
        DECLARE @scriptum NVARCHAR(MAX);

        DROP TABLE IF EXISTS #gradus_modus_oneris;
        CREATE TABLE #gradus_modus_oneris
        (
            nomen_modus_oneris VARCHAR(50)   NOT NULL
        );

        SET @scriptum = N'
        BULK INSERT #gradus_modus_oneris
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

        INSERT INTO classificationum.modus_oneris(nomen_modus_oneris)
        SELECT gmo.nomen_modus_oneris
        FROM #gradus_modus_oneris gmo;

        DROP TABLE #gradus_modus_oneris;
    COMMIT TRANSACTION;
END
GO