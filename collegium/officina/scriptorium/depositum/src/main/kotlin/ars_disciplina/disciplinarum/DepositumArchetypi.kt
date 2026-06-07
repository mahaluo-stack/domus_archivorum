package ars_disciplina.disciplinarum

import ars_disciplina.Depositum
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_ARCHETYPUS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_DESCRIPTIO
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_NOMEN_ARCHETYPI
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_DISCIPLINARUM
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_ARCHETYPI
import ars_disciplina.disciplinarum.tabula.Archetypus
import ars_disciplina.disciplinarum.valores.DescriptioArchetypi
import ars_disciplina.disciplinarum.valores.NomenArchetypi
import ars_disciplina.disciplinarum.valores.identitas.ArchetypusIdentitas
import java.sql.ResultSet

object DepositumArchetypi : Depositum<Archetypus>() {
    override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_DISCIPLINARUM"
    override val nomenTabulae = NOMEN_TABULAE_ARCHETYPI
    override fun crea(rs: ResultSet): Archetypus {
        return Archetypus(
            ArchetypusIdentitas(rs.getInt(NOMEN_COLUMNAE_ARCHETYPUS_IDENTITAS)),
            NomenArchetypi(rs.getString(NOMEN_COLUMNAE_NOMEN_ARCHETYPI)),
            DescriptioArchetypi(rs.getString(NOMEN_COLUMNAE_DESCRIPTIO))
        )
    }
}