package ars_disciplina.nexuum

import ars_disciplina.Depositum
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_DISCIPLINAE_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_NEXUUM
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import java.sql.ResultSet

abstract class DepositumNexuumDisciplinae<T> : Depositum<T>() {

    final override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_NEXUUM"
    protected abstract val nomenColumnaeAlterumIdentitas: String

    final override fun scriptumLectionis(): String =
        """
        SELECT
            $NOMEN_COLUMNAE_DISCIPLINAE_IDENTITAS,
            $nomenColumnaeAlterumIdentitas
        FROM $nomenSchemata.$nomenTabulae
        """.trimIndent()

    protected abstract fun crea(disciplinaeIdentitas: DisciplinaeIdentitas, alterumIdentitas: Int): T

    final override fun crea(rs: ResultSet): T = crea(
        DisciplinaeIdentitas(rs.getInt(NOMEN_COLUMNAE_DISCIPLINAE_IDENTITAS)),
        rs.getInt(nomenColumnaeAlterumIdentitas)
    )
}