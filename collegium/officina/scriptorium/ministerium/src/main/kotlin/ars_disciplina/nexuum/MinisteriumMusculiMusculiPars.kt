package ars_disciplina.nexuum

import ConexioArsDisciplina
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas

object MinisteriumMusculiMusculiPars {
    fun ponere(
        musculiIdentitas: MusculiIdentitas,
        musculiParsIdentitas: MusculiParsIdentitas
    ): Int =
        ConexioArsDisciplina.renova(
            """
            INSERT INTO nexuum.musculi_musculi_pars (
                musculi_identitas,
                musculi_pars_identitas
            )
            VALUES (?, ?)
            ON CONFLICT DO NOTHING;
            """.trimIndent()
        ) {
            setInt(1, musculiIdentitas.valor)
            setInt(2, musculiParsIdentitas.valor)
        }

    fun delerePerClavem(
        musculiIdentitas: MusculiIdentitas
    ): Int =
        ConexioArsDisciplina.dele(
            """
            DELETE FROM nexuum.musculi_musculi_pars
            WHERE musculi_identitas = ?;
            """.trimIndent()
        ) {
            setInt(1, musculiIdentitas.valor)
        }

    fun delerePerMusculiPars(
        musculiParsIdentitas: MusculiParsIdentitas
    ): Int =
        ConexioArsDisciplina.dele(
            """
        DELETE FROM nexuum.musculi_musculi_pars
        WHERE musculi_pars_identitas = ?;
        """.trimIndent()
        ) {
            setInt(1, musculiParsIdentitas.valor)
        }
}