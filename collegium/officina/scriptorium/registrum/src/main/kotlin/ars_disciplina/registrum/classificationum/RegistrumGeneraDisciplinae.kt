package ars_disciplina.registrum.classificationum

import ars_disciplina.classificationum.tabula.GeneraDisciplinae
import ars_disciplina.classificationum.valores.identitas.GeneraDisciplinaeIdentitas
import ars_disciplina.commune.registra.catalogus.RegistraGeneraDisciplinae
import ars_disciplina.registrum.Registrum

object RegistrumGeneraDisciplinae : Registrum<GeneraDisciplinaeIdentitas, GeneraDisciplinae>()  {

    override fun omnia(): Collection<GeneraDisciplinae> = RegistraGeneraDisciplinae.omnia()
    override fun invenirePerClavemNecesse(identitas: GeneraDisciplinaeIdentitas): GeneraDisciplinae = RegistraGeneraDisciplinae.invenirePerClavemNecesse(identitas)
    override fun invenireSiAdest(identitas: GeneraDisciplinaeIdentitas): GeneraDisciplinae? = RegistraGeneraDisciplinae.invenireSiAdest(identitas)
}