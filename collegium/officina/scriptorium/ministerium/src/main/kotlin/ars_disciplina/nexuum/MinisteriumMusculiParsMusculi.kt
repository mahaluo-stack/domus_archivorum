package ars_disciplina.nexuum

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas

class MinisteriumMusculiParsMusculi {
    fun inserta(musculiParsIdentitas: MusculiParsIdentitas, musculiIdentitas: MusculiIdentitas): Int =
        ConexioArsDisciplina.inserta(
            """
        INSERT INTO ars_disciplina.nexuum.musculi_pars_musculi(
            musculi_pars_identitas,
            musculi_identitas
        )
        VALUES (?, ?);
        SELECT SCOPE_IDENTITY();
        """.trimIndent()
        ) {
            setInt(1, musculiParsIdentitas.valor)
            setInt(2, musculiIdentitas.valor)
        }
}