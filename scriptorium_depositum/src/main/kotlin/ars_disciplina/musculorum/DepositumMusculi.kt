package ars_disciplina.musculorum

import ars_disciplina.Conexio
import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculi
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import org.example.exemplaria.tabulae.Musculi

object DepositumMusculi {
    fun legeOmnes(): Set<Musculi> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT 
                    musculi_regio_identitas,
                    nomen_musculi,
                    descriptio
                FROM ars_disciplina.musculorum.musculi
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val collectio = mutableSetOf<Musculi>()
                    while (rs.next()) {
                        val musculiRegioIdentitas = MusculiRegioIdentitas(valor = rs.getInt("musculi_regio_identitas"))
                        val identitas = MusculiIdentitas(valor = rs.getInt("musculi_identitas"))
                        val nomen = NomenMusculi(valor = rs.getString("nomen_musculi"))
                        val descriptio = DescriptioMusculi(valor = rs.getString("descriptio") ?: "")

                        collectio.add(
                            Musculi(
                                identitas,
                                musculiRegioIdentitas,
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