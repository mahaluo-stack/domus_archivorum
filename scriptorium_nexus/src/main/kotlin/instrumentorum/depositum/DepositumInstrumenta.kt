package org.example.instrumentorum.depositum

import ars_disciplina.instrumentorum.tabula.Instrumenta
import ars_disciplina.instrumentorum.valores.DescriptioInstrumenti
import ars_disciplina.instrumentorum.valores.NomenInstrumenti
import ars_disciplina.instrumentorum.valores.identitas.InstrumentaIdentitas
import org.example.commune.conexio.Conexio

object DepositumInstrumenta {
    fun legeOmnes(): Set<Instrumenta> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT 
                    instrumenta_identitas, 
                    nomen_instrumenti,
                    descriptio
                FROM ars_disciplina.instrumentorum.instrumenta
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val collectio = mutableSetOf<Instrumenta>()
                    while (rs.next()) {
                        val identitas = InstrumentaIdentitas(valor = rs.getInt("instrumenta_identitas"))
                        val nomen = NomenInstrumenti(valor = rs.getString("nomen_instrumenti"))
                        val descriptio = DescriptioInstrumenti(valor = rs.getString("descriptio") ?: "")

                        collectio.add(
                            Instrumenta(
                                identitas,
                                nomen,
                                descriptio
                            )
                        )
                    }
                    return collectio
                }
            }
        }
    }
}