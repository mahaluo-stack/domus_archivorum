package org.example.exemplaria.tabulae

import ars_disciplina.musculorum.valores.NomenMusculi
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas

data class MusculiRegio(
    val identitas: MusculiRegioIdentitas,
    val nomen: NomenMusculi
)
