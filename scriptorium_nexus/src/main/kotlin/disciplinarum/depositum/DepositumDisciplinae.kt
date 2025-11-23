package org.example.disciplinarum.depositum

import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import ars_disciplina.disciplinarum.tabula.Disciplinae
import ars_disciplina.disciplinarum.valores.DescriptioDisciplina
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import org.example.commune.conexio.Conexio

object DepositumDisciplinae {
    fun legeOmnes(): Set<Disciplinae> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT 
                    disciplinae_identitas, 
                    nomen_disciplinae,
                    descriptio
                FROM ars_disciplina.disciplinarum.disciplinae
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val collectio = mutableSetOf<Disciplinae>()
                    while (rs.next()) {
                        val identitas = DisciplinaeIdentitas(valor = rs.getInt("disciplinae_identitas"))
                        val nomen = NomenDisciplinae(valor = rs.getString("nomen_disciplinae"))
                        val descriptio = DescriptioDisciplina(valor = rs.getString("descriptio") ?: "")
                        collectio.add(
                            Disciplinae(
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

    fun inserta(entia: EntiaDisciplina): Int {
        Conexio.getConnection().use { conn ->
            val sql = """
                INSERT INTO ars_disciplina.disciplinarum.disciplinae(nomen_disciplinae, descriptio)
                VALUES (?, ?);
                SELECT SCOPE_IDENTITY();
            """
            conn.prepareStatement(sql).use { ps ->
                ps.setString(1, entia.disciplinae.nomen.toString())
                ps.setString(2, entia.disciplinae.descriptio.toString())
                ps.executeQuery().use { rs ->
                    rs.next()
                    return rs.getInt(1)
                }
            }
        }
    }
}