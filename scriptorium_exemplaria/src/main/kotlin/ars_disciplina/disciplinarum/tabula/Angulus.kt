package ars_disciplina.disciplinarum.tabula

import ars_disciplina.disciplinarum.valores.AngulusPercentum
import ars_disciplina.disciplinarum.valores.identitas.AngulusIdentitas

data class Angulus(
    val angulusIdentitas: AngulusIdentitas,
    val angulus: AngulusPercentum
)