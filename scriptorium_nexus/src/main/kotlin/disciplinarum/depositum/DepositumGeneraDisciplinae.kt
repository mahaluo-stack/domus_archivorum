package org.example.disciplinarum.depositum

import ars_disciplina.classificationum.tabula.GeneraDisciplinae
import ars_disciplina.classificationum.valores.DescriptioClassificationum
import ars_disciplina.classificationum.valores.NomenGeneraDisciplinae
import ars_disciplina.classificationum.valores.identitas.GeneraDisciplinaeIdentitas
import org.example.commune.conexio.Conexio

object DepositumGeneraDisciplinae {
    fun legeOmnes(): Set<GeneraDisciplinae> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT 
                    genera_disciplinae_identitas, 
                    nomen_genus_disciplinae,
                    descriptio
                FROM ars_disciplina.classificationum.genera_disciplinae
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val collectio = mutableSetOf<GeneraDisciplinae>()
                    while (rs.next()) {
                        val identitas = GeneraDisciplinaeIdentitas(valor = rs.getInt("genera_disciplinae_identitas"))
                        val nomen = NomenGeneraDisciplinae(valor = rs.getString("nomen_genus_disciplinae"))
                        val descriptio = DescriptioClassificationum(valor = rs.getString("descriptio") ?: "")
                        collectio.add(
                            GeneraDisciplinae(
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