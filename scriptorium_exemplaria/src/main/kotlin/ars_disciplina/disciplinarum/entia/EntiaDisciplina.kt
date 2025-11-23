package ars_disciplina.disciplinarum.entia

import ars_disciplina.classificationum.tabula.GeneraDisciplinae
import ars_disciplina.classificationum.tabula.LateralisDisciplinae
import ars_disciplina.classificationum.tabula.ModusOneris
import ars_disciplina.disciplinarum.tabula.Angulus
import ars_disciplina.disciplinarum.tabula.DisciplinaVariationes
import ars_disciplina.disciplinarum.tabula.Disciplinae
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.prehensionum.tabula.GeneraPrehensionis
import ars_disciplina.prehensionum.tabula.Prehensiones

class EntiaDisciplina(
    val disciplinae: Disciplinae,
    val generaDisciplinae: GeneraDisciplinae,
    val motus: Motus,

    val modusOneris: Set<ModusOneris>,
    val lateralisDisciplinae: Set<LateralisDisciplinae>,
    val variationes: Set<DisciplinaVariationes>,

    val angulus: Set<Angulus>?,
    val prehensiones: Set<Prehensiones>?,
    val generaPrehensiones: Set<GeneraPrehensionis>?
)