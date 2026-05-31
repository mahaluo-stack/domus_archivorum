package ars_disciplina.classificationum.tabula

import ars_disciplina.classificationum.valores.NomenLateralis
import ars_disciplina.classificationum.valores.identitas.LateralisIdentitas

data class Lateralis(
    val lateralisIdentitas: LateralisIdentitas,
    val nomen: NomenLateralis
)