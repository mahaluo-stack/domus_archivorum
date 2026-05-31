package org.example.disciplinarum.depositum

import ars_disciplina.prehensionum.tabula.GeneraPrehensionis
import ars_disciplina.prehensionum.valores.DescriptioPrehensionis
import ars_disciplina.prehensionum.valores.NomenGeneraPrehensionis
import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas
import org.example.commune.conexio.Conexio

object DepositumGeneraPrehensionis {
    fun legeOmnes(): Set<GeneraPrehensionis> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT 
                    genera_prehensionis_identitas, 
                    nomen_genus_prehensionis,
                    descriptio
                FROM ars_disciplina.prehensionum.genera_prehensionis
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val collectio = mutableSetOf<GeneraPrehensionis>()
                    while (rs.next()) {
                        val identitas = GeneraPrehensionisIdentitas(valor = rs.getInt("genera_prehensionis_identitas"))
                        val nomen = NomenGeneraPrehensionis(valor = rs.getString("nomen_genus_prehensionis"))
                        val descriptio = DescriptioPrehensionis(valor = rs.getString("descriptio") ?: "")
                        collectio.add(
                            GeneraPrehensionis(
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