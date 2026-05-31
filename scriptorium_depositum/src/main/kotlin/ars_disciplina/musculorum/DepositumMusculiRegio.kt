package ars_disciplina.musculorum

import ars_disciplina.Conexio
import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculiRegio
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import org.example.exemplaria.tabulae.MusculiRegio

object DepositumMusculiRegio {
    fun legeOmnes(): Set<MusculiRegio> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT
                    nomen_musculi_regio,
                    descriptio
                FROM ars_disciplina.musculorum.musculi_regio
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val collectio = mutableSetOf<MusculiRegio>()
                    while (rs.next()) {
                        val identitas = MusculiRegioIdentitas(valor = rs.getInt("musculi_regio_identitas"))
                        val nomen = NomenMusculiRegio(valor = rs.getString("nomen_musculi_regio"))
                        val descriptio = DescriptioMusculi(valor = rs.getString("descriptio") ?: "")
                        collectio.add(
                            MusculiRegio(
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