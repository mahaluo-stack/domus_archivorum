package ars_disciplina.nexuum

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas

class MinisteriumMusculiMusculiRegio {
    fun inserta(musculiIdentitas: MusculiIdentitas, musculiRegioIdentitas: MusculiRegioIdentitas): Int =
        ConexioArsDisciplina.inserta(
            """
        INSERT INTO ars_disciplina.nexuum.musculi_musculi_regio(
            musculi_identitas,
            musculi_regio_identitas
        )
        VALUES (?, ?);
        SELECT SCOPE_IDENTITY();
        """.trimIndent()
        ) {
            setInt(1, musculiIdentitas.valor)
            setInt(2, musculiRegioIdentitas.valor)
        }
}