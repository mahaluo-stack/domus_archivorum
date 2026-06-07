package ars_disciplina.regularum

import ars_disciplina.Depositum
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_DESCRIPTIO
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_GENUS_REGULAE
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_NOMEN_REGULAE
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_REGULAE_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_REGULARUM
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_REGULAE
import ars_disciplina.regularum.tabula.Regulae
import ars_disciplina.regularum.valores.DescriptioRegulae
import ars_disciplina.regularum.valores.GenusRegulae
import ars_disciplina.regularum.valores.NomenRegulae
import ars_disciplina.regularum.valores.RegulaeIdentitas
import java.sql.ResultSet

object DepositumRegulae : Depositum<Regulae>() {
    override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_REGULARUM"
    override val nomenTabulae = NOMEN_TABULAE_REGULAE
    override fun crea(
        rs: ResultSet
    ) = Regulae(
        RegulaeIdentitas(rs.getInt(NOMEN_COLUMNAE_REGULAE_IDENTITAS)),
        NomenRegulae(rs.getString(NOMEN_COLUMNAE_NOMEN_REGULAE)),
        GenusRegulae(rs.getString(NOMEN_COLUMNAE_GENUS_REGULAE)),
        DescriptioRegulae(rs.getString(NOMEN_COLUMNAE_DESCRIPTIO) ?: "")
    )
}