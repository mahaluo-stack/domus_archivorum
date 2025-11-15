package org.example.disciplinarum.depositum

import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.valores.NomenMotus
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import org.example.commune.conexio.Conexio

object DepositumMotus {
    fun legeOmnes(): List<Motus> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT 
                    motus_identitas, 
                    nomen_motus 
                FROM ars_disciplina.disciplinarum.motus
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val out = mutableListOf<Motus>()
                    while (rs.next()) {
                        val identitas = MotusIdentitas(identitas = rs.getInt("motus_identitas"))
                        val nomen = NomenMotus(nomen = rs.getString("nomen_motus"))
                        out.add(
                            Motus(
                                identitas,
                                nomen
                            )
                        )
                    }
                    return out
                }
            }
        }
    }
}