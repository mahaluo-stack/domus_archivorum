package ars_disciplina.nexuum

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas

object MinisteriumMusculiMusculiRegio {
    fun ponere(
        musculiIdentitas: MusculiIdentitas,
        musculiRegioIdentitas: MusculiRegioIdentitas
    ) =
        ConexioArsDisciplina.renova(
            """
            INSERT INTO nexuum.musculi_musculi_regio (
                musculi_identitas,
                musculi_regio_identitas
            )
            VALUES (?, ?)
            ON CONFLICT DO NOTHING;
            """.trimIndent()
        ) {
            setInt(1, musculiIdentitas.valor)
            setInt(2, musculiRegioIdentitas.valor)
        }
}