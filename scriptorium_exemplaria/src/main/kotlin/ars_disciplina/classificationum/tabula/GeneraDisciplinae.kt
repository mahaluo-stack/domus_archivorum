package ars_disciplina.classificationum.tabula

import ars_disciplina.classificationum.valores.DescriptioClassificationum
import ars_disciplina.classificationum.valores.NomenGeneraDisciplinae
import ars_disciplina.classificationum.valores.identitas.GeneraDisciplinaeIdentitas
import ars_disciplina.disciplinarum.valores.DescriptioDisciplina

data class GeneraDisciplinae(
    val generaDisciplinaeIdentitas: GeneraDisciplinaeIdentitas,
    val nomen: NomenGeneraDisciplinae,
    val descriptio: DescriptioClassificationum? = DescriptioClassificationum("")
)