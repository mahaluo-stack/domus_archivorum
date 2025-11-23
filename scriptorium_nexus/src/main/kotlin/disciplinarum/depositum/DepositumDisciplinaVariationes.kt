package org.example.disciplinarum.depositum

import ars_disciplina.disciplinarum.tabula.DisciplinaVariationes
import ars_disciplina.disciplinarum.valores.NomenDisciplinaVariatones
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaVariationesIdentitas
import org.example.commune.conexio.Conexio

object DepositumDisciplinaVariationes {
    fun legeOmnes(): Set<DisciplinaVariationes> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT 
                    disciplina_variationes_identitas, 
                    nomen_variationis 
                FROM ars_disciplina.disciplinarum.disciplina_variationes
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val collectio = mutableSetOf<DisciplinaVariationes>()
                    while (rs.next()) {
                        val identitas = DisciplinaVariationesIdentitas(valor = rs.getInt("disciplina_variationes_identitas"))
                        val nomen = NomenDisciplinaVariatones(valor = rs.getString("nomen_variationis"))
                        collectio.add(
                            DisciplinaVariationes(
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