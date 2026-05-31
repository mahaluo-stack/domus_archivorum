package ars_disciplina.musculorum

import ars_disciplina.Conexio
import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculiPars
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import org.example.exemplaria.tabulae.MusculiPars

object DepositumMusculiRegio {
    fun legeOmnes(): Set<MusculiPars> {
        Conexio.getConnection().use { conn ->
            val sql = """
                SELECT 
                    musculi_identitas,
                    nomen_musculi_pars,
                    descriptio
                FROM ars_disciplina.musculorum.musculi_pars
            """.trimIndent()
            conn.prepareStatement(sql).use { ps ->
                ps.executeQuery().use { rs ->
                    val collectio = mutableSetOf<MusculiPars>()
                    while (rs.next()) {
                        val musculiIdentitas = MusculiIdentitas(valor = rs.getInt("musculi_identitas"))
                        val identitas = MusculiParsIdentitas(valor = rs.getInt("musculi_pars_identitas"))
                        val nomen = NomenMusculiPars(valor = rs.getString("nomen_musculi_pars"))
                        val descriptio = DescriptioMusculi(valor = rs.getString("descriptio") ?: "")

                        collectio.add(
                            MusculiPars(
                                identitas,
                                musculiIdentitas,
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