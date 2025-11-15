package ars_disciplina.disciplinarum.entia

import ars_disciplina.disciplinarum.tabula.*

class EntiaDisciplina(
    val disciplinae: Disciplinae,
    val generaDisciplinae: List<GeneraDisciplinae>,
    val angulus: List<Angulus>?,
    val variationes: List<DisciplinaVariationes>,
    val prehensiones: List<Prehensiones>,
    val generaPrehensiones: List<GeneraPrehensionis>,
    val motus: List<Motus>
)