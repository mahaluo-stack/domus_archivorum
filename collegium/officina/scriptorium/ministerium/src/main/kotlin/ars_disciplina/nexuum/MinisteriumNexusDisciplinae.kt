package org.example.nexuum.ministeria.nexus

import ConexioArsDisciplina
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_DISCIPLINAE_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_NEXUUM
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas

abstract class MinisteriumNexusDisciplinae<T> {

    private val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_NEXUUM"
    protected abstract val nomenTabulae: String
    protected abstract val nomenColumnae: String
    protected abstract fun identitas(identitas: T): Int

    protected fun inserta(disciplinaeIdentitas: DisciplinaeIdentitas, alterumIdentitas: Int):
            Int = ConexioArsDisciplina.inserta(
        """
        SELECT
            $NOMEN_COLUMNAE_DISCIPLINAE_IDENTITAS,
            $nomenColumnae
        FROM $nomenSchemata.$nomenTabulae
        ON CONFLICT DO NOTHING;
        """.trimIndent()
    ) {
        setInt(1, disciplinaeIdentitas.valor)
        setInt(2, alterumIdentitas)
    }
}