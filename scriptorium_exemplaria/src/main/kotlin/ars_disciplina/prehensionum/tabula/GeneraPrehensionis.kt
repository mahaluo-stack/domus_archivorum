package ars_disciplina.prehensionum.tabula

import ars_disciplina.prehensionum.valores.DescriptioPrehensionis
import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas
import ars_disciplina.prehensionum.valores.NomenGeneraPrehensionis

data class GeneraPrehensionis(
    val generaPrehensionis: GeneraPrehensionisIdentitas,
    val nomen: NomenGeneraPrehensionis,
    val descriptio: DescriptioPrehensionis
)
