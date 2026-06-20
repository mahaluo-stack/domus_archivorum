package org.example.exemplaria.tabulae

import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculiPars
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas

data class MusculiPars(
    val musculiParsIdentitas: MusculiParsIdentitas,
    val nomen: NomenMusculiPars,
    val descriptio: DescriptioMusculi
)
