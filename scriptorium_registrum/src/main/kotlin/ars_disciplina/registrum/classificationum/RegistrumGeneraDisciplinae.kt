package ars_disciplina.registrum.classificationum

import ars_disciplina.classificationum.tabula.GeneraDisciplinae
import ars_disciplina.classificationum.valores.identitas.GeneraDisciplinaeIdentitas
import ars_disciplina.commune.registra.RegistraGeneraDisciplinae

object RegistrumGeneraDisciplinae {

    fun omnia(): Collection<GeneraDisciplinae> = RegistraGeneraDisciplinae.omnia()
    fun invenire(identitas: GeneraDisciplinaeIdentitas): GeneraDisciplinae = RegistraGeneraDisciplinae.invenirePerClavemNecesse(identitas)
}