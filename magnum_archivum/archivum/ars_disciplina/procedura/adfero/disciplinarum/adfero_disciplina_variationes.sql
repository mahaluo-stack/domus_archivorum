USE ars_disciplina
GO

CREATE OR ALTER PROCEDURE disciplinarum.adfero_disciplina_variationes @via_tabula VARCHAR(4000)
AS
BEGIN
    BEGIN TRANSACTION
        SET NOCOUNT ON;

        DECLARE @tabula VARCHAR(MAX) = @via_tabula + '\disciplinarum\disciplina_variationes.csv';
        DECLARE @scriptum NVARCHAR(MAX);

        DROP TABLE IF EXISTS #gradus_disciplina_variationes;
        CREATE TABLE #gradus_disciplina_variationes
        (
            nomen_variationis VARCHAR(50) NOT NULL
        );

        SET @scriptum = N'
        BULK INSERT #gradus_disciplina_variationes
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

        INSERT INTO disciplinarum.disciplina_variationes(nomen_variationis)
        SELECT gdv.nomen_variationis
        FROM #gradus_disciplina_variationes gdv;

        DROP TABLE #gradus_disciplina_variationes;
    COMMIT TRANSACTION;
END
GO