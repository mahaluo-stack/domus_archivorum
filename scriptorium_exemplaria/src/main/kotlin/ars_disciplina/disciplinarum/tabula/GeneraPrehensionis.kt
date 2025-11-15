package ars_disciplina.disciplinarum.tabula

import ars_disciplina.disciplinarum.valores.DescriptioPrehensionis
import ars_disciplina.disciplinarum.valores.identitas.GeneraPrehensionisIdentitas
import ars_disciplina.disciplinarum.valores.NomenGeneraPrehensionis

data class GeneraPrehensionis(
    val generaPrehensionis: GeneraPrehensionisIdentitas,
    val nomen: NomenGeneraPrehensionis,
    val descriptio: DescriptioPrehensionis
)
