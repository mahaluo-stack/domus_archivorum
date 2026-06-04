package ars_disciplina.disciplinarum.tabula

import ars_disciplina.disciplinarum.valores.DescriptioDisciplinae
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas

data class Disciplinae(
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val nomen: NomenDisciplinae,
    val descriptio: DescriptioDisciplinae? = DescriptioDisciplinae("")
)