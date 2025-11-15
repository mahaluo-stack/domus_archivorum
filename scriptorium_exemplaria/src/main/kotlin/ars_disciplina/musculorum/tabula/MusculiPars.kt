package org.example.exemplaria.tabulae

import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculi
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas

data class MusculiPars(
    val identitas: MusculiParsIdentitas,
    val musculiIdentitas: MusculiIdentitas,
    val nomen: NomenMusculi,
    val descriptio: DescriptioMusculi
)
