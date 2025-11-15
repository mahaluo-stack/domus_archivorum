package org.example.exemplaria.tabulae

import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculi
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas

data class Musculi(
    val identitas: MusculiIdentitas,
    val musculiRegioIdentitas: MusculiRegioIdentitas,
    val nomen: NomenMusculi,
    val descriptio: DescriptioMusculi
)
