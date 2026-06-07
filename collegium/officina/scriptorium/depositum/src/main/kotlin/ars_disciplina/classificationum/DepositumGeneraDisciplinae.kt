package ars_disciplina.classificationum

import ars_disciplina.Depositum
import ars_disciplina.classificationum.tabula.GeneraDisciplinae
import ars_disciplina.classificationum.valores.DescriptioClassificationum
import ars_disciplina.classificationum.valores.NomenGeneraDisciplinae
import ars_disciplina.classificationum.valores.identitas.GeneraDisciplinaeIdentitas
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae
import java.sql.ResultSet

object DepositumGeneraDisciplinae : Depositum<GeneraDisciplinae>() {
    override val nomenSchemata =
        "${ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA}.${ConstantiaNomenSchemata.NOMEN_SCHEMATA_CLASSIFICATIONUM}"
    override val nomenTabulae = ConstantiaNomenTabulae.NOMEN_TABULAE_GENERA_DISCIPLINAE
    override fun crea(rs: ResultSet): GeneraDisciplinae {
        return GeneraDisciplinae(
            GeneraDisciplinaeIdentitas(rs.getInt(ConstantiaNomenColumnae.NOMEN_COLUMNAE_GENERA_DISCIPLINAE_IDENTITAS)),
            NomenGeneraDisciplinae(rs.getString(ConstantiaNomenColumnae.NOMEN_COLUMNAE_NOMEN_GENUS_DISCIPLINAE)),
            DescriptioClassificationum(rs.getString(ConstantiaNomenColumnae.NOMEN_COLUMNAE_DESCRIPTIO) ?: "")
        )
    }
}