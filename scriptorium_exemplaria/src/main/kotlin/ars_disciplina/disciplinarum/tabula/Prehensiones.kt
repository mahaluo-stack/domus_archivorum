package ars_disciplina.disciplinarum.tabula

import ars_disciplina.disciplinarum.valores.DescriptioPrehensionis
import ars_disciplina.disciplinarum.valores.identitas.PrehensionesIdentitas
import ars_disciplina.disciplinarum.valores.NomenPrehensionis

data class Prehensiones(
    val prehensionesIdentitas: PrehensionesIdentitas,
    val nomen: NomenPrehensionis,
    val descriptio: DescriptioPrehensionis
)
