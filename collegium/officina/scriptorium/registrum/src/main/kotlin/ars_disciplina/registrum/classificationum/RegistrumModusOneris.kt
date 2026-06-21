package ars_disciplina.registrum.classificationum

import ars_disciplina.classificationum.tabula.Lateralis
import ars_disciplina.classificationum.tabula.ModusOneris
import ars_disciplina.classificationum.valores.identitas.LateralisIdentitas
import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas
import ars_disciplina.commune.registra.RegistraModusOneris
import ars_disciplina.registrum.Registrum

object RegistrumModusOneris : Registrum<ModusOnerisIdentitas, ModusOneris>() {

    override fun omnia(): Collection<ModusOneris> = RegistraModusOneris.omnia()
    override fun invenire(identitas: ModusOnerisIdentitas): ModusOneris = RegistraModusOneris.invenirePerClavemNecesse(identitas)
}