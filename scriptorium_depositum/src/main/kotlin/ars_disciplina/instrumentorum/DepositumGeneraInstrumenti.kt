package org.example.instrumentorum.depositum

import ars_disciplina.instrumentorum.tabula.GenusInstrumenti
import ars_disciplina.instrumentorum.valores.NomenGenusInstrumenti
import ars_disciplina.instrumentorum.valores.identitas.GenusInstrumentiIdentitas
import org.example.commune.conexio.Conexio

object DepositumGeneraInstrumenti {
    fun legeOmnes(): Set<GenusInstrumenti> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT 
                    genus_instrumenti_identitas, 
                    nomen_genus_instrumenti
                FROM ars_disciplina.instrumentorum.genus_instrumenti
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val collectio = mutableSetOf<GenusInstrumenti>()
                    while (rs.next()) {
                        val identitas = GenusInstrumentiIdentitas(valor = rs.getInt("genus_instrumenti_identitas"))
                        val nomen = NomenGenusInstrumenti(valor = rs.getString("nomen_genus_instrumenti"))
                        collectio.add(
                            GenusInstrumenti(
                                identitas,
                                nomen
                            )
                        )
                    }
                    return collectio
                }
            }
        }
    }
}