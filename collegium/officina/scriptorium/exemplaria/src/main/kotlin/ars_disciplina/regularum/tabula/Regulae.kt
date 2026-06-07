package ars_disciplina.regularum.tabula

import ars_disciplina.regularum.valores.DescriptioRegulae
import ars_disciplina.regularum.valores.GenusRegulae
import ars_disciplina.regularum.valores.NomenRegulae
import ars_disciplina.regularum.valores.RegulaeIdentitas

data class Regulae(
    val regulaeIdentitas: RegulaeIdentitas,
    val nomen: NomenRegulae,
    val genus: GenusRegulae,
    val descriptio: DescriptioRegulae
)