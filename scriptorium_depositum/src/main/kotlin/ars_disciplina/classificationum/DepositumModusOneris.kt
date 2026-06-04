package org.example.disciplinarum.depositum

import ars_disciplina.DepositumTabulae
import ars_disciplina.classificationum.tabula.ModusOneris
import ars_disciplina.classificationum.valores.NomenModusOneris
import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MODUS_ONERIS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_NOMEN_MODUS_ONERIS
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_CLASSIFICATIONUM
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_MODUS_ONERIS
import java.sql.ResultSet

object DepositumModusOneris : DepositumTabulae<ModusOneris>() {
    override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_CLASSIFICATIONUM"
    override val nomenTabulae = NOMEN_TABULAE_MODUS_ONERIS
    override fun crea(rs: ResultSet): ModusOneris {
        return ModusOneris(
            ModusOnerisIdentitas(rs.getInt(NOMEN_COLUMNAE_MODUS_ONERIS_IDENTITAS)),
            NomenModusOneris(rs.getString(NOMEN_COLUMNAE_NOMEN_MODUS_ONERIS))
        )
    }
}