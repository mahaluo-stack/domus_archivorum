USE ars_disciplina
GO

CREATE OR ALTER PROCEDURE prehensionum.adfero_prehensiones @via_tabula VARCHAR(4000)
AS
BEGIN
    BEGIN TRANSACTION
        SET NOCOUNT ON;

        DECLARE @tabula VARCHAR(MAX) = @via_tabula + '\prehensionum\prehensiones.csv';
        DECLARE @scriptum NVARCHAR(MAX);

        DROP TABLE IF EXISTS #gradus_prehensiones;
        CREATE TABLE #gradus_prehensiones
        (
            nomen_prehensionis VARCHAR(50) NOT NULL
        );

        SET @scriptum = N'
        BULK INSERT #gradus_prehensiones
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

        INSERT INTO prehensionum.prehensiones(nomen_prehensionis)
        SELECT gp.nomen_prehensionis
        FROM #gradus_prehensiones gp;

        DROP TABLE #gradus_prehensiones;
    COMMIT TRANSACTION;
END
GO