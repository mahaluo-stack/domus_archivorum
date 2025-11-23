package org.example.disciplinarum.depositum

import ars_disciplina.classificationum.tabula.ModusOneris
import ars_disciplina.classificationum.valores.NomenModusOneris
import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas
import org.example.commune.conexio.Conexio

object DepositumModusOneris {
    fun legeOmnes(): Set<ModusOneris> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT 
                    modus_oneris_identitas, 
                    nomen_modus_oneris
                FROM ars_disciplina.classificationum.modus_oneris
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val collectio = mutableSetOf<ModusOneris>()
                    while (rs.next()) {
                        val identitas = ModusOnerisIdentitas(valor = rs.getInt("modus_oneris_identitas"))
                        val nomen = NomenModusOneris(valor = rs.getString("nomen_modus_oneris"))
                        collectio.add(
                            ModusOneris(
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