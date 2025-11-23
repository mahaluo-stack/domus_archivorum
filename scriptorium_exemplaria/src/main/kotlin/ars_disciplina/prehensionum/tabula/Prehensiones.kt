package ars_disciplina.prehensionum.tabula

import ars_disciplina.prehensionum.valores.DescriptioPrehensionis
import ars_disciplina.prehensionum.valores.NomenPrehensionis
import ars_disciplina.prehensionum.valores.identitas.PrehensionesIdentitas

data class Prehensiones(
    val prehensionesIdentitas: PrehensionesIdentitas,
    val nomen: NomenPrehensionis,
    val descriptio: DescriptioPrehensionis
)
