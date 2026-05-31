USE ars_disciplina
GO

CREATE OR ALTER PROCEDURE regularum.adfero_regulae @via_tabula VARCHAR(4000)
AS
BEGIN
    BEGIN TRANSACTION
        SET NOCOUNT ON;

        DECLARE @tabula VARCHAR(MAX) = @via_tabula + '\regularum\regulae.csv';
        DECLARE @scriptum NVARCHAR(MAX);

        DROP TABLE IF EXISTS #gradus_regulae;
        CREATE TABLE #gradus_regulae
        (
            nomen_regulae VARCHAR(50)   NOT NULL,
            descriptio    VARCHAR(4000) NOT NULL
        );

        SET @scriptum = N'
        BULK INSERT #gradus_regulae
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

        INSERT INTO regularum.regulae(nomen_regulae, descriptio)
        SELECT gr.nomen_regulae,
               gr.descriptio
        FROM #gradus_regulae gr;

        DROP TABLE #gradus_regulae;
    COMMIT TRANSACTION;
END
GO