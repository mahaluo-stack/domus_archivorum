package ars_disciplina.disciplinarum.tabula

import ars_disciplina.disciplinarum.valores.DescriptioArchetypi
import ars_disciplina.disciplinarum.valores.NomenArchetypi
import ars_disciplina.disciplinarum.valores.identitas.ArchetypusIdentitas

data class Archetypus(
    val archetypiIdentitas: ArchetypusIdentitas,
    val nomenArchetypi: NomenArchetypi,
    val descriptio: DescriptioArchetypi
)