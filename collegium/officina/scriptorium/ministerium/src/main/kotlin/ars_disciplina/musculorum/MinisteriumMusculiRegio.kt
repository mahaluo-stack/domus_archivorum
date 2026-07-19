package ars_disciplina.musculorum

import ConexioArsDisciplina
import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculiRegio
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import org.example.exemplaria.tabulae.MusculiRegio

object MinisteriumMusculiRegio {
    fun delere(
        musculiRegioIdentitas: MusculiRegioIdentitas
    ): Int = ConexioArsDisciplina.dele(
        """
            DELETE FROM musculorum.musculi_regio
            WHERE musculi_regio_identitas = ?;
            """.trimIndent()
    ) {
        setInt(1, musculiRegioIdentitas.valor)
    }

    fun inserta(
        nomenMusculiRegio: NomenMusculiRegio, descriptioMusculiRegio: DescriptioMusculi
    ): Int = ConexioArsDisciplina.inserta(
        """
        INSERT INTO ars_disciplina.musculorum.musculi_regio(
            nomen_musculi_regio, descriptio
        )
        VALUES (?, ?);
        ON CONFLICT DO NOTHING;
        """.trimIndent()
    ) {
        setString(1, nomenMusculiRegio.valor)
        setString(2, descriptioMusculiRegio.valor)
    }

    fun ponere(
        musculiRegio: MusculiRegio
    ): Int = ConexioArsDisciplina.renova(
        """
        UPDATE musculorum.musculi_regio
        SET
        nomen_musculi_regio = ?,
        descriptio = ?
        WHERE musculi_regio_identitas = ?;
        """.trimIndent()
    ) {
        setString(1, musculiRegio.nomen.valor)
        setString(2, musculiRegio.descriptio.valor)
        setInt(3, musculiRegio.musculiRegioIdentitas.valor)
    }
}