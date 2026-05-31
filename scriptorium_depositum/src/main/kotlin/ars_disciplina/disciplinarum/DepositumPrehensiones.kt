package org.example.disciplinarum.depositum

import ars_disciplina.prehensionum.tabula.Prehensiones
import ars_disciplina.prehensionum.valores.DescriptioPrehensionis
import ars_disciplina.prehensionum.valores.NomenPrehensionis
import ars_disciplina.prehensionum.valores.identitas.PrehensionesIdentitas
import org.example.commune.conexio.Conexio

object DepositumPrehensiones {
    fun legeOmnes(): Set<Prehensiones> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT 
                    prehensiones_identitas, 
                    nomen_prehensionis,
                    descriptio
                FROM ars_disciplina.prehensionum.prehensiones
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val collectio = mutableSetOf<Prehensiones>()
                    while (rs.next()) {
                        val identitas = PrehensionesIdentitas(valor = rs.getInt("prehensiones_identitas"))
                        val nomen = NomenPrehensionis(valor = rs.getString("nomen_prehensionis"))
                        val descriptio = DescriptioPrehensionis(valor = rs.getString("descriptio") ?: "")
                        collectio.add(
                            Prehensiones(
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