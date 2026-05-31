package ars_disciplina.disciplinarum.entia

import ars_disciplina.classificationum.tabula.GeneraDisciplinae
import ars_disciplina.classificationum.tabula.Lateralis
import ars_disciplina.classificationum.tabula.ModusOneris
import ars_disciplina.disciplinarum.tabula.Angulus
import ars_disciplina.disciplinarum.tabula.Variationes
import ars_disciplina.disciplinarum.tabula.Disciplinae
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.prehensionum.tabula.GeneraPrehensionis
import ars_disciplina.prehensionum.tabula.Prehensiones

class EntiaDisciplina(
    val disciplinae: Disciplinae,
    val generaDisciplinae: GeneraDisciplinae,
    val motus: Motus,

    val modusOneris: Set<ModusOneris>,
    val lateralis: Set<Lateralis>,
    val variationes: Set<Variationes>,

    val angulus: Set<Angulus>,
    val prehensiones: Set<Prehensiones>,
    val generaPrehensiones: Set<GeneraPrehensionis>
)