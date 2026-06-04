package org.example.commune.registrum

import ars_disciplina.disciplinarum.tabula.Angulus
import ars_disciplina.disciplinarum.tabula.Disciplinae
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.tabula.Variationes
import ars_disciplina.disciplinarum.valores.AngulusPercentum
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import ars_disciplina.disciplinarum.valores.NomenMotus
import ars_disciplina.disciplinarum.valores.NomenVariatones

object RegistraDisciplinae : Registra<NomenDisciplinae, Disciplinae>({ it.nomen })
object RegistraVariationes : Registra<NomenVariatones, Variationes>({ it.nomen })
object RegistraMotus : Registra<NomenMotus, Motus>({ it.nomen })
object RegistraAngulus : Registra<AngulusPercentum, Angulus>({ it.angulus })