package ars_disciplina.registrum.disciplinarum

import ars_disciplina.commune.registra.catalogus.RegistraArchetypi
import ars_disciplina.disciplinarum.tabula.Archetypus
import ars_disciplina.disciplinarum.valores.identitas.ArchetypusIdentitas
import ars_disciplina.registrum.Registrum

object RegistrumArchetypi : Registrum<ArchetypusIdentitas, Archetypus>() {

    override fun omnia(): Collection<Archetypus> = RegistraArchetypi.omnia()
    override fun invenirePerClavemNecesse(identitas: ArchetypusIdentitas): Archetypus = RegistraArchetypi.invenirePerClavemNecesse(identitas)
    override fun invenireSiAdest(identitas: ArchetypusIdentitas): Archetypus? = RegistraArchetypi.invenireSiAdest(identitas)
}