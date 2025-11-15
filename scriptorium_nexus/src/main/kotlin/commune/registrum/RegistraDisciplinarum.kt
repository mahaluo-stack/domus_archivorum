package org.example.commune.registrum

import ars_disciplina.disciplinarum.tabula.Angulus
import ars_disciplina.disciplinarum.tabula.Disciplinae
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.valores.AngulusPercentum
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import ars_disciplina.disciplinarum.valores.NomenMotus

object RegistraMotus : Registra<NomenMotus, Motus>({ it.nomen })
object RegistraAngulus : Registra<AngulusPercentum, Angulus>({ it.angulus })
object RegistraDisciplinae : Registra<NomenDisciplinae, Disciplinae>({ it.nomen })