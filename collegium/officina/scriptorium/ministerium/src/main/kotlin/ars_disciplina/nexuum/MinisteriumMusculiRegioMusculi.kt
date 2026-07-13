package ars_disciplina.nexuum

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas

object MinisteriumMusculiRegioMusculi {
    fun ponere(
        musculiRegioIdentitas: MusculiRegioIdentitas, musculiIdentitas: MusculiIdentitas
    ): Int = ConexioArsDisciplina.renova(
        """
            INSERT INTO nexuum.musculi_regio_musculi (
             musculi_regio_identitas,
                musculi_identitas
            )
            VALUES (?, ?)
            ON CONFLICT DO NOTHING;
            """.trimIndent()
    ) {
        setInt(1, musculiRegioIdentitas.valor)
        setInt(2, musculiIdentitas.valor)
    }

    fun delerePerClavem(
        musculiRegioIdentitas: MusculiRegioIdentitas
    ): Int = ConexioArsDisciplina.dele(
        """
            DELETE FROM nexuum.musculi_regio_musculi
            WHERE musculi_regio_identitas = ?;
            """.trimIndent()
    ) {
        setInt(1, musculiRegioIdentitas.valor)
    }
}