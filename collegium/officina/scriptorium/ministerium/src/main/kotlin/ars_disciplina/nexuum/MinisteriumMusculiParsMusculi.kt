package ars_disciplina.nexuum

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas

object MinisteriumMusculiParsMusculi {
    fun ponere(
        musculiParsIdentitas: MusculiParsIdentitas,
        musculiIdentitas: MusculiIdentitas
    ) =
        ConexioArsDisciplina.renova(
            """
            INSERT INTO nexuum.musculi_musculi_regio (
                musculi_pars_identitas,
                musculi_identitas
            )
            VALUES (?, ?)
            ON CONFLICT DO NOTHING;
            """.trimIndent()
        ) {
            setInt(1, musculiParsIdentitas.valor)
            setInt(2, musculiIdentitas.valor)
        }
}