package org.example.disciplinarum.depositum

import ars_disciplina.Depositum
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_DESCRIPTIO
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_DISCIPLINAE_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_NOMEN_DISCIPLINAE
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_DISCIPLINARUM
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINAE
import ars_disciplina.disciplinarum.tabula.Disciplinae
import ars_disciplina.disciplinarum.valores.DescriptioDisciplinae
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import java.sql.ResultSet

object DepositumDisciplinae : Depositum<Disciplinae>() {
    override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_DISCIPLINARUM"
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINAE
    override fun crea(rs: ResultSet): Disciplinae {
        return Disciplinae(
            DisciplinaeIdentitas(rs.getInt(NOMEN_COLUMNAE_DISCIPLINAE_IDENTITAS)),
            NomenDisciplinae(rs.getString(NOMEN_COLUMNAE_NOMEN_DISCIPLINAE)),
            DescriptioDisciplinae(rs.getString(NOMEN_COLUMNAE_DESCRIPTIO) ?: "")
        )
    }
}