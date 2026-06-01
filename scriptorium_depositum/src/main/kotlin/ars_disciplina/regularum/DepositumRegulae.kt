package ars_disciplina.regularum

import ars_disciplina.Conexio
import ars_disciplina.regularum.tabula.Regulae
import ars_disciplina.regularum.valores.DescriptioRegulae
import ars_disciplina.regularum.valores.NomenRegulae
import ars_disciplina.regularum.valores.RegulaeIdentitas

object DepositumRegulae {
    fun legeOmnes(): Set<Regulae> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT
                    nomen_regulae,
                    descriptio
                FROM ars_disciplina.regularum.regulae
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val collectio = mutableSetOf<Regulae>()
                    while (rs.next()) {
                        val identitas = RegulaeIdentitas(valor = rs.getInt("regulae_identitas"))
                        val nomen = NomenRegulae(valor = rs.getString("nomen_regulae"))
                        val descriptio = DescriptioRegulae(valor = rs.getString("descriptio") ?: "")
                        collectio.add(
                            Regulae(
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