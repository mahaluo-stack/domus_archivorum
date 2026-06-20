package org.example.instrumentorum.depositum

import ars_disciplina.Depositum
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_GENERA_INSTRUMENTI_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_NOMEN_GENUS_INSTRUMENTI
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_INSTRUMENTORUM
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_GENERA_INSTRUMENTI
import ars_disciplina.instrumentorum.tabula.GenusInstrumenti
import ars_disciplina.instrumentorum.valores.NomenGenusInstrumenti
import ars_disciplina.instrumentorum.valores.identitas.GenusInstrumentiIdentitas
import java.sql.ResultSet

object DepositumGeneraInstrumenti : Depositum<GenusInstrumenti>() {
    override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_INSTRUMENTORUM"
    override val nomenTabulae = NOMEN_TABULAE_GENERA_INSTRUMENTI
    override fun crea(rs: ResultSet): GenusInstrumenti {
        return GenusInstrumenti(
            GenusInstrumentiIdentitas(rs.getInt(NOMEN_COLUMNAE_GENERA_INSTRUMENTI_IDENTITAS)),
            NomenGenusInstrumenti(rs.getString(NOMEN_COLUMNAE_NOMEN_GENUS_INSTRUMENTI))
        )
    }
}