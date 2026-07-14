package ars_disciplina.registrum.classificationum

import ars_disciplina.classificationum.tabula.Lateralis
import ars_disciplina.classificationum.valores.identitas.LateralisIdentitas
import ars_disciplina.commune.registra.catalogus.RegistraLateralis
import ars_disciplina.registrum.Registrum

object RegistrumLateralis : Registrum<LateralisIdentitas, Lateralis>() {

    override fun omnia(): Collection<Lateralis> = RegistraLateralis.omnia()
    override fun invenire(identitas: LateralisIdentitas): Lateralis = RegistraLateralis.invenirePerClavemNecesse(identitas)
}