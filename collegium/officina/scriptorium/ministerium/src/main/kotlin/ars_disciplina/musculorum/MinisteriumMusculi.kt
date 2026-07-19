package ars_disciplina.musculorum

import ConexioArsDisciplina
import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculi
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import org.example.exemplaria.tabulae.Musculi

object MinisteriumMusculi {
    fun delere(
        musculiIdentitas: MusculiIdentitas
    ): Int = ConexioArsDisciplina.dele(
        """
            DELETE FROM musculorum.musculi
            WHERE musculi_identitas = ?;
            """.trimIndent()
    ) {
        setInt(1, musculiIdentitas.valor)
    }

    fun inserta(
        nomenMusculi: NomenMusculi, descriptioMusculi: DescriptioMusculi
    ): Int = ConexioArsDisciplina.inserta(
        """
        INSERT INTO ars_disciplina.musculorum.musculi(
            nomen_musculi, descriptio
        )
        VALUES (?, ?);
        ON CONFLICT DO NOTHING;
        """.trimIndent()
    ) {
        setString(1, nomenMusculi.valor)
        setString(2, descriptioMusculi.valor)
    }

    fun ponere(
        musculi: Musculi
    ): Int = ConexioArsDisciplina.renova(
        """
        UPDATE musculorum.musculi
        SET
        nomen_musculi = ?,
        descriptio = ?
        WHERE musculi_identitas = ?;
        """.trimIndent()
    ) {
        setString(1, musculi.nomen.valor)
        setString(2, musculi.descriptio.valor)
        setInt(3, musculi.musculiIdentitas.valor)
    }
}