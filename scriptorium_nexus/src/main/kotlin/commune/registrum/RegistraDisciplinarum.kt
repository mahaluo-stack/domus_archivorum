package org.example.commune.registrum

import ars_disciplina.classificationum.tabula.GeneraDisciplinae
import ars_disciplina.classificationum.tabula.LateralisDisciplinae
import ars_disciplina.classificationum.tabula.ModusOneris
import ars_disciplina.classificationum.valores.NomenGeneraDisciplinae
import ars_disciplina.classificationum.valores.NomenLateralisDisciplinae
import ars_disciplina.classificationum.valores.NomenModusOneris
import ars_disciplina.disciplinarum.tabula.Angulus
import ars_disciplina.disciplinarum.tabula.DisciplinaVariationes
import ars_disciplina.disciplinarum.tabula.Disciplinae
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.valores.AngulusPercentum
import ars_disciplina.disciplinarum.valores.NomenDisciplinaVariatones
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import ars_disciplina.disciplinarum.valores.NomenMotus
import ars_disciplina.prehensionum.tabula.GeneraPrehensionis
import ars_disciplina.prehensionum.tabula.Prehensiones
import ars_disciplina.prehensionum.valores.NomenGeneraPrehensionis
import ars_disciplina.prehensionum.valores.NomenPrehensionis

object RegistraDisciplinae : Registra<NomenDisciplinae, Disciplinae>({ it.nomen })
object RegistraDisciplinaVariationes : Registra<NomenDisciplinaVariatones, DisciplinaVariationes>({ it.nomen })
object RegistraMotus : Registra<NomenMotus, Motus>({ it.nomen })
object RegistraAngulus : Registra<AngulusPercentum, Angulus>({ it.angulus })

object RegistraPrehensiones : Registra<NomenPrehensionis, Prehensiones>({ it.nomen })
object RegistraGeneraPrehensionis : Registra<NomenGeneraPrehensionis, GeneraPrehensionis>({ it.nomen })

object RegistraGeneraDisciplinae : Registra<NomenGeneraDisciplinae, GeneraDisciplinae>({ it.nomen })
object RegistraLateralisDisciplinae : Registra<NomenLateralisDisciplinae, LateralisDisciplinae>({ it.nomen })
object RegistraModusOneris : Registra<NomenModusOneris, ModusOneris>({ it.nomen })