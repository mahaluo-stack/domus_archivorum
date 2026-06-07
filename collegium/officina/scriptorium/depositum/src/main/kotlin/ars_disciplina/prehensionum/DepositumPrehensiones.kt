package org.example.disciplinarum.depositum

import ars_disciplina.Depositum
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_DESCRIPTIO
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_NOMEN_PREHENSIONIS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_PREHENSIONES_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_PREHENSIONUM
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_PREHENSIONES
import ars_disciplina.prehensionum.tabula.Prehensiones
import ars_disciplina.prehensionum.valores.DescriptioPrehensionis
import ars_disciplina.prehensionum.valores.NomenPrehensionis
import ars_disciplina.prehensionum.valores.identitas.PrehensionesIdentitas
import java.sql.ResultSet

object DepositumPrehensiones : Depositum<Prehensiones>() {
    override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_PREHENSIONUM"
    override val nomenTabulae = NOMEN_TABULAE_PREHENSIONES
    override fun crea(
        rs: ResultSet
    ) = Prehensiones(
        PrehensionesIdentitas(rs.getInt(NOMEN_COLUMNAE_PREHENSIONES_IDENTITAS)),
        NomenPrehensionis(rs.getString(NOMEN_COLUMNAE_NOMEN_PREHENSIONIS)),
        DescriptioPrehensionis(rs.getString(NOMEN_COLUMNAE_DESCRIPTIO) ?: "")
    )
}