package org.example.disciplinarum.depositum

import ars_disciplina.Depositum
import ars_disciplina.classificationum.tabula.Lateralis
import ars_disciplina.classificationum.valores.NomenLateralis
import ars_disciplina.classificationum.valores.identitas.LateralisIdentitas
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_LATERALIS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_NOMEN_LATERALIS
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_CLASSIFICATIONUM
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_LATERALIS
import java.sql.ResultSet

object DepositumLateralis : Depositum<Lateralis>() {
    override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_CLASSIFICATIONUM"
    override val nomenTabulae = NOMEN_TABULAE_LATERALIS
    override fun crea(rs: ResultSet): Lateralis {
        return Lateralis(
            LateralisIdentitas(rs.getInt(NOMEN_COLUMNAE_LATERALIS_IDENTITAS)),
            NomenLateralis(rs.getString(NOMEN_COLUMNAE_NOMEN_LATERALIS))
        )
    }
}