package org.example.disciplinarum.depositum

import ars_disciplina.Depositum
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_DESCRIPTIO
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MOTUS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_NOMEN_MOTUS
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_DISCIPLINARUM
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_MOTUS
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.valores.DescriptioMotus
import ars_disciplina.disciplinarum.valores.NomenMotus
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import java.sql.ResultSet

object DepositumMotus : Depositum<Motus>() {
    override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_DISCIPLINARUM"
    override val nomenTabulae = NOMEN_TABULAE_MOTUS
    override fun crea(rs: ResultSet): Motus {
        return Motus(
            MotusIdentitas(rs.getInt(NOMEN_COLUMNAE_MOTUS_IDENTITAS)),
            NomenMotus(rs.getString(NOMEN_COLUMNAE_NOMEN_MOTUS)),
            DescriptioMotus(rs.getString(NOMEN_COLUMNAE_DESCRIPTIO) ?: "")
        )
    }
}