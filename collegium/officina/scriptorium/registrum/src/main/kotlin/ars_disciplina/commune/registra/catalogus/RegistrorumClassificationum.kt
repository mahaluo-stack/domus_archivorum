package ars_disciplina.commune.registra.catalogus

import ars_disciplina.classificationum.tabula.GeneraDisciplinae
import ars_disciplina.classificationum.tabula.Lateralis
import ars_disciplina.classificationum.tabula.ModusOneris
import ars_disciplina.classificationum.valores.identitas.GeneraDisciplinaeIdentitas
import ars_disciplina.classificationum.valores.identitas.LateralisIdentitas
import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas
import org.example.commune.registrum.Registra

object RegistraGeneraDisciplinae : Registra<GeneraDisciplinaeIdentitas, GeneraDisciplinae>({ it.generaDisciplinaeIdentitas })
object RegistraLateralis : Registra<LateralisIdentitas, Lateralis>({ it.lateralisIdentitas })
object RegistraModusOneris : Registra<ModusOnerisIdentitas, ModusOneris>({ it.modusOnerisIdentitas })