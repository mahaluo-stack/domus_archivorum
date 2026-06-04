package org.example.disciplinarum.depositum

import ars_disciplina.DepositumTabulae
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_ANGULUS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_ANGULUS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_DISCIPLINARUM
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_ANGULUS
import ars_disciplina.disciplinarum.tabula.Angulus
import ars_disciplina.disciplinarum.valores.AngulusPercentum
import ars_disciplina.disciplinarum.valores.identitas.AngulusIdentitas
import java.sql.ResultSet

object DepositumAngulus : DepositumTabulae<Angulus>() {
    override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_DISCIPLINARUM"
    override val nomenTabulae = NOMEN_TABULAE_ANGULUS
    override fun crea(rs: ResultSet): Angulus {
        return Angulus(
            AngulusIdentitas(rs.getInt(NOMEN_COLUMNAE_ANGULUS_IDENTITAS)),
            AngulusPercentum(rs.getDouble(NOMEN_COLUMNAE_ANGULUS))
        )
    }
}