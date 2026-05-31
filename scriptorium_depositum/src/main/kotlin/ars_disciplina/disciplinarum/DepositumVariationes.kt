package org.example.disciplinarum.depositum

import ars_disciplina.Conexio
import ars_disciplina.disciplinarum.tabula.Variationes
import ars_disciplina.disciplinarum.valores.NomenVariatones
import ars_disciplina.disciplinarum.valores.identitas.VariationesIdentitas

object DepositumVariationes {
    fun legeOmnes(): Set<Variationes> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT 
                    variationes_identitas, 
                    nomen_variationis 
                FROM ars_disciplina.disciplinarum.variationes
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val collectio = mutableSetOf<Variationes>()
                    while (rs.next()) {
                        val identitas = VariationesIdentitas(valor = rs.getInt("variationes_identitas"))
                        val nomen = NomenVariatones(valor = rs.getString("nomen_variationis"))
                        collectio.add(
                            Variationes(
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