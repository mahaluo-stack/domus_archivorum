package ars_disciplina.registrum.classificationum

import ars_disciplina.classificationum.tabula.ModusOneris
import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas
import ars_disciplina.commune.registra.RegistraModusOneris

object RegistrumModusOneris {

    fun omnia(): Collection<ModusOneris> = RegistraModusOneris.omnia()
    fun invenire(identitas: ModusOnerisIdentitas): ModusOneris = RegistraModusOneris.invenirePerClavemNecesse(identitas)
}