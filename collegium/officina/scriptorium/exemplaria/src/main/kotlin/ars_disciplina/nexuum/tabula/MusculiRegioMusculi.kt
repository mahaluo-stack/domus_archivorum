package ars_disciplina.nexuum.tabula

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas

data class MusculiRegioMusculi(
    val musculiRegioIdentitas: MusculiRegioIdentitas,
    val musculiIdentitas: MusculiIdentitas
)