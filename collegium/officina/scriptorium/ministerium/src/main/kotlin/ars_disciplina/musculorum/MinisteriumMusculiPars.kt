package ars_disciplina.musculorum

import ConexioArsDisciplina
import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculiPars
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import org.example.exemplaria.tabulae.MusculiPars

object MinisteriumMusculiPars {
    fun delere(
        musculiParsIdentitas: MusculiParsIdentitas
    ): Int = ConexioArsDisciplina.dele(
        """
            DELETE FROM musculorum.musculi_pars
            WHERE musculi_pars_identitas = ?;
            """.trimIndent()
    ) {
        setInt(1, musculiParsIdentitas.valor)
    }

    fun inserta(
        nomenMusculiPars: NomenMusculiPars, descriptioMusculiPars: DescriptioMusculi
    ): Int = ConexioArsDisciplina.inserta(
        """
        INSERT INTO ars_disciplina.musculorum.musculi_pars(
            nomen_musculi_pars, descriptio
        )
        VALUES (?, ?);
        ON CONFLICT DO NOTHING;
        """.trimIndent()
    ) {
        setString(1, nomenMusculiPars.valor)
        setString(2, descriptioMusculiPars.valor)
    }

    fun ponere(
        musculiPars: MusculiPars
    ): Int = ConexioArsDisciplina.renova(
        """
        UPDATE musculorum.musculi_pars
        SET
        nomen_musculi_pars = ?,
        descriptio = ?
        WHERE musculi_pars_identitas = ?;
        """.trimIndent()
    ) {
        setString(1, musculiPars.nomen.valor)
        setString(2, musculiPars.descriptio.valor)
        setInt(3, musculiPars.musculiParsIdentitas.valor)
    }
}
