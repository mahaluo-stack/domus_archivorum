package org.example.disciplinarum.depositum

import ars_disciplina.classificationum.tabula.LateralisDisciplinae
import ars_disciplina.classificationum.valores.NomenLateralisDisciplinae
import ars_disciplina.classificationum.valores.identitas.LateralisDisciplinaeIdentitas
import org.example.commune.conexio.Conexio

object DepositumLateralisDisciplinae {
    fun legeOmnes(): Set<LateralisDisciplinae> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT 
                    lateralis_disciplinae_identitas, 
                    nomen_lateralis_disciplinae
                FROM ars_disciplina.classificationum.lateralis_disciplinae
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val collectio = mutableSetOf<LateralisDisciplinae>()
                    while (rs.next()) {
                        val identitas = LateralisDisciplinaeIdentitas(valor = rs.getInt("lateralis_disciplinae_identitas"))
                        val nomen = NomenLateralisDisciplinae(valor = rs.getString("nomen_lateralis_disciplinae"))
                        collectio.add(
                            LateralisDisciplinae(
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