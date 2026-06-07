package ars_disciplina.prehensionum.tabula

import ars_disciplina.prehensionum.valores.DescriptioPrehensionis
import ars_disciplina.prehensionum.valores.NomenGeneraPrehensionis
import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas

data class GeneraPrehensionis(
    val generaPrehensionisIdentitas: GeneraPrehensionisIdentitas,
    val nomen: NomenGeneraPrehensionis,
    val descriptio: DescriptioPrehensionis
)
