package org.example.commune.registrum

import ars_disciplina.disciplinarum.tabula.Angulus
import ars_disciplina.disciplinarum.tabula.Disciplinae
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.tabula.Variationes
import ars_disciplina.disciplinarum.valores.identitas.AngulusIdentitas
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import ars_disciplina.disciplinarum.valores.identitas.VariationesIdentitas

object RegistraDisciplinae : Registra<DisciplinaeIdentitas, Disciplinae>({ it.disciplinaeIdentitas })
object RegistraVariationes : Registra<VariationesIdentitas, Variationes>({ it.variationesIdentitas })
object RegistraMotus : Registra<MotusIdentitas, Motus>({ it.motusIdentitas })
object RegistraAngulus : Registra<AngulusIdentitas, Angulus>({ it.angulusIdentitas })