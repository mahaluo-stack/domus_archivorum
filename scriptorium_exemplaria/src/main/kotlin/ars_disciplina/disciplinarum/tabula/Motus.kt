package ars_disciplina.disciplinarum.tabula

import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import ars_disciplina.disciplinarum.valores.NomenMotus

data class Motus(
    val motusIdentitas: MotusIdentitas,
    val nomen: NomenMotus
)
