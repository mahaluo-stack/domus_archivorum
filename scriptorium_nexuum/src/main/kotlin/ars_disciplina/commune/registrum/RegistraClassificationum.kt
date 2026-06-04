package ars_disciplina.commune.registrum

import ars_disciplina.classificationum.tabula.GeneraDisciplinae
import ars_disciplina.classificationum.tabula.Lateralis
import ars_disciplina.classificationum.tabula.ModusOneris
import ars_disciplina.classificationum.valores.NomenGeneraDisciplinae
import ars_disciplina.classificationum.valores.NomenLateralis
import ars_disciplina.classificationum.valores.NomenModusOneris
import org.example.commune.registrum.Registra

object RegistraGeneraDisciplinae : Registra<NomenGeneraDisciplinae, GeneraDisciplinae>({ it.nomen })
object RegistraLateralis : Registra<NomenLateralis, Lateralis>({ it.nomen })
object RegistraModusOneris : Registra<NomenModusOneris, ModusOneris>({ it.nomen })