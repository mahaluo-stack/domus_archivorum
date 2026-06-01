package org.example.disciplinarum.depositum

import ars_disciplina.Conexio
import ars_disciplina.classificationum.tabula.Lateralis
import ars_disciplina.classificationum.valores.NomenLateralis
import ars_disciplina.classificationum.valores.identitas.LateralisIdentitas

object DepositumLateralis {
    fun legeOmnes(): Set<Lateralis> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT 
                    lateralis_identitas, 
                    nomen_lateralis
                FROM ars_disciplina.classificationum.lateralis
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val collectio = mutableSetOf<Lateralis>()
                    while (rs.next()) {
                        val identitas = LateralisIdentitas(valor = rs.getInt("lateralis_identitas"))
                        val nomen = NomenLateralis(valor = rs.getString("nomen_lateralis"))
                        collectio.add(
                            Lateralis(
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