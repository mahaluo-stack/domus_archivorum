package ars_disciplina.disciplinarum.tabula

import ars_disciplina.disciplinarum.valores.DescriptioDisciplina
import ars_disciplina.disciplinarum.valores.identitas.GeneraDisciplinaeIdentitas
import ars_disciplina.disciplinarum.valores.NomenGeneraDisciplinae

data class GeneraDisciplinae(
    val generaDisciplinaeIdentitas: GeneraDisciplinaeIdentitas,
    val nomen: NomenGeneraDisciplinae,
    val descriptio: DescriptioDisciplina
)
