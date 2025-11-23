package ars_disciplina.disciplinarum.tabula

import ars_disciplina.disciplinarum.valores.DescriptioDisciplina
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas

data class Disciplinae(
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val nomen: NomenDisciplinae,
    val descriptio: DescriptioDisciplina? = DescriptioDisciplina("")
)