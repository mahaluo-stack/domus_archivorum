package ars_disciplina.classificationum.tabula

import ars_disciplina.classificationum.valores.NomenModusOneris
import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas

data class ModusOneris(
    val modusOnerisIdentitas: ModusOnerisIdentitas,
    val nomen: NomenModusOneris
)