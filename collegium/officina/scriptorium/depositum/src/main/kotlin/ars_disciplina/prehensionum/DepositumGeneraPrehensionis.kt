package org.example.disciplinarum.depositum

import ars_disciplina.Depositum
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_DESCRIPTIO
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_GENERA_PREHENSIONIS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_NOMEN_GENUS_PREHENSIONIS
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_PREHENSIONUM
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_GENERA_PREHENSIONIOS
import ars_disciplina.prehensionum.tabula.GeneraPrehensionis
import ars_disciplina.prehensionum.valores.DescriptioPrehensionis
import ars_disciplina.prehensionum.valores.NomenGeneraPrehensionis
import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas
import java.sql.ResultSet

object DepositumGeneraPrehensionis : Depositum<GeneraPrehensionis>() {
    override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_PREHENSIONUM"
    override val nomenTabulae = NOMEN_TABULAE_GENERA_PREHENSIONIOS
    override fun crea(
        rs: ResultSet
    ) = GeneraPrehensionis(
        GeneraPrehensionisIdentitas(rs.getInt(NOMEN_COLUMNAE_GENERA_PREHENSIONIS_IDENTITAS)),
        NomenGeneraPrehensionis(rs.getString(NOMEN_COLUMNAE_NOMEN_GENUS_PREHENSIONIS)),
        DescriptioPrehensionis(rs.getString(NOMEN_COLUMNAE_DESCRIPTIO) ?: "")
    )
}