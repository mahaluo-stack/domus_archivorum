package ars_disciplina.disciplinarum.tabula

import ars_disciplina.disciplinarum.valores.identitas.VariationesIdentitas
import ars_disciplina.disciplinarum.valores.NomenVariatones

data class Variationes(
    val variationesIdentitas: VariationesIdentitas,
    val nomen: NomenVariatones
)