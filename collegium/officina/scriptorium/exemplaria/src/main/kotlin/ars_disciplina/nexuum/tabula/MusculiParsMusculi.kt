package ars_disciplina.nexuum.tabula

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas

data class MusculiParsMusculi(
    val musculiParsIdentitas: MusculiParsIdentitas,
    val musculiIdentitas: MusculiIdentitas
)