package org.example.exemplaria.tabulae

import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculiRegio
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas

data class MusculiRegio(
    val musculiRegioIdentitas: MusculiRegioIdentitas,
    val nomen: NomenMusculiRegio,
    val descriptio: DescriptioMusculi
)
