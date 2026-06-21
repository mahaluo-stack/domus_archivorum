package ars_disciplina.registrum.classificationum

import ars_disciplina.classificationum.tabula.GeneraDisciplinae
import ars_disciplina.classificationum.valores.identitas.GeneraDisciplinaeIdentitas
import ars_disciplina.commune.registra.RegistraGeneraDisciplinae
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import ars_disciplina.registrum.Registrum

object RegistrumGeneraDisciplinae : Registrum<GeneraDisciplinaeIdentitas, GeneraDisciplinae>()  {

    override fun omnia(): Collection<GeneraDisciplinae> = RegistraGeneraDisciplinae.omnia()
    override fun invenire(identitas: GeneraDisciplinaeIdentitas): GeneraDisciplinae = RegistraGeneraDisciplinae.invenirePerClavemNecesse(identitas)
}