package ars_disciplina.registrum.classificationum

import ars_disciplina.classificationum.tabula.Lateralis
import ars_disciplina.classificationum.valores.identitas.LateralisIdentitas
import ars_disciplina.commune.registra.RegistraLateralis

object RegistrumLateralis {

    fun omnia(): Collection<Lateralis> = RegistraLateralis.omnia()
    fun invenire(identitas: LateralisIdentitas): Lateralis = RegistraLateralis.invenirePerClavemNecesse(identitas)
}