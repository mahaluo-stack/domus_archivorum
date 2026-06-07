package org.example.instrumentorum.depositum

import ars_disciplina.Depositum
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_DESCRIPTIO
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_INSTRUMENTA_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_NOMEN_INSTRUMENTI
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_INSTRUMENTORUM
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_INSTRUMENTI
import ars_disciplina.instrumentorum.tabula.Instrumenta
import ars_disciplina.instrumentorum.valores.DescriptioInstrumenti
import ars_disciplina.instrumentorum.valores.NomenInstrumenti
import ars_disciplina.instrumentorum.valores.identitas.InstrumentaIdentitas
import java.sql.ResultSet

object DepositumInstrumenta : Depositum<Instrumenta>() {
    override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_INSTRUMENTORUM"
    override val nomenTabulae = NOMEN_TABULAE_INSTRUMENTI
    override fun crea(rs: ResultSet): Instrumenta {
        return Instrumenta(
            InstrumentaIdentitas(rs.getInt(NOMEN_COLUMNAE_INSTRUMENTA_IDENTITAS)),
            NomenInstrumenti(rs.getString(NOMEN_COLUMNAE_NOMEN_INSTRUMENTI)),
            DescriptioInstrumenti(rs.getString(NOMEN_COLUMNAE_DESCRIPTIO) ?: "")
        )
    }
}