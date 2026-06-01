package org.example.disciplinarum.depositum

import ars_disciplina.Conexio
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.valores.DescriptioMotus
import ars_disciplina.disciplinarum.valores.NomenMotus
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas

object DepositumMotus {
    fun legeOmnes(): Set<Motus> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT 
                    motus_identitas, 
                    nomen_motus
                FROM ars_disciplina.disciplinarum.motus
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val collectio = mutableSetOf<Motus>()
                    while (rs.next()) {
                        val identitas = MotusIdentitas(valor = rs.getInt("motus_identitas"))
                        val nomen = NomenMotus(valor = rs.getString("nomen_motus"))
                        val descriptio = DescriptioMotus(valor = rs.getString("descriptio") ?: "")
                        collectio.add(
                            Motus(
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