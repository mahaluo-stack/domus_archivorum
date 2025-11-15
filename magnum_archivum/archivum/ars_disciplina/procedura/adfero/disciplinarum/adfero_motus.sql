USE ars_disciplina
GO

CREATE OR ALTER PROCEDURE disciplinarum.adfero_motus @via_tabula VARCHAR(4000)
AS
BEGIN
    BEGIN TRANSACTION
        SET NOCOUNT ON;

        DECLARE @tabula VARCHAR(MAX) = @via_tabula + '\disciplinarum\motus.csv';
        DECLARE @scriptum NVARCHAR(MAX);

        DROP TABLE IF EXISTS #gradus_motus;
        CREATE TABLE #gradus_motus
        (
            nomen_motus VARCHAR(50)   NOT NULL,
            descriptio  VARCHAR(4000) NULL
        );

        SET @scriptum = N'
        BULK INSERT #gradus_motus
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

        INSERT INTO disciplinarum.motus(nomen_motus,
                                        descriptio)
        SELECT gm.nomen_motus,
               gm.descriptio
        FROM #gradus_motus gm;

        DROP TABLE #gradus_motus;
    COMMIT TRANSACTION;
END
GO