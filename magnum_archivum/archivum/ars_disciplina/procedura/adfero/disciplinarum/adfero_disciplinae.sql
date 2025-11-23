USE ars_disciplina
GO

CREATE OR ALTER PROCEDURE disciplinarum.adfero_disciplinae @via_tabula VARCHAR(4000)
AS
BEGIN
    BEGIN TRANSACTION
        SET NOCOUNT ON;

        DECLARE @tabula VARCHAR(MAX) = @via_tabula + '\disciplinarum\disciplinae.csv';
        DECLARE @scriptum NVARCHAR(MAX);

        DROP TABLE IF EXISTS #gradus_disciplinae;
        CREATE TABLE #gradus_disciplinae
        (
            nomen_disciplinae VARCHAR(50)   NOT NULL,
            descriptio        VARCHAR(4000) NULL
        );

        SET @scriptum = N'
        BULK INSERT #gradus_disciplinae
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

        INSERT INTO disciplinarum.disciplinae(nomen_disciplinae,
                                              descriptio)
        SELECT gd.nomen_disciplinae,
               gd.descriptio
        FROM #gradus_disciplinae gd;

        DROP TABLE #gradus_disciplinae;
    COMMIT TRANSACTION;
END
GO