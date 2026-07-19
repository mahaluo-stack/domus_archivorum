package ars_disciplina.registrum.classificationum

import ars_disciplina.classificationum.tabula.ModusOneris
import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas
import ars_disciplina.commune.registra.catalogus.RegistraModusOneris
import ars_disciplina.registrum.Registrum

object RegistrumModusOneris : Registrum<ModusOnerisIdentitas, ModusOneris>() {

    override fun omnia(): Collection<ModusOneris> = RegistraModusOneris.omnia()
    override fun invenirePerClavemNecesse(identitas: ModusOnerisIdentitas): ModusOneris = RegistraModusOneris.invenirePerClavemNecesse(identitas)
    override fun invenireSiAdest(identitas: ModusOnerisIdentitas): ModusOneris? = RegistraModusOneris.invenireSiAdest(identitas)
}