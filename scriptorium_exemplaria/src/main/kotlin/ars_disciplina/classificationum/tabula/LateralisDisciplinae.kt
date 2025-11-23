package ars_disciplina.classificationum.tabula

import ars_disciplina.classificationum.valores.NomenLateralisDisciplinae
import ars_disciplina.classificationum.valores.identitas.LateralisDisciplinaeIdentitas

data class LateralisDisciplinae(
    val lateralisDisciplinaeIdentitas: LateralisDisciplinaeIdentitas,
    val nomen: NomenLateralisDisciplinae
)