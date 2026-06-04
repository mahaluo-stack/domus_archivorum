package org.example.disciplinarum.depositum

import ars_disciplina.DepositumTabulae
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_NOMEN_PREHENSIONIS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_PREHENSIONES_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_DISCIPLINARUM
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_VARIATIONES
import ars_disciplina.disciplinarum.tabula.Variationes
import ars_disciplina.disciplinarum.valores.NomenVariatones
import ars_disciplina.disciplinarum.valores.identitas.VariationesIdentitas
import java.sql.ResultSet

object DepositumVariationes : DepositumTabulae<Variationes>() {
    override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_DISCIPLINARUM"
    override val nomenTabulae = NOMEN_TABULAE_VARIATIONES
    override fun crea(rs: ResultSet): Variationes {
        return Variationes(
            VariationesIdentitas(rs.getInt(NOMEN_COLUMNAE_PREHENSIONES_IDENTITAS)),
            NomenVariatones(rs.getString(NOMEN_COLUMNAE_NOMEN_PREHENSIONIS))
        )
    }
}