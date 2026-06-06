package ars_disciplina.registrum.disciplinarum

import ars_disciplina.commune.registra.RegistraArchetypi
import ars_disciplina.disciplinarum.tabula.Archetypus
import ars_disciplina.disciplinarum.valores.identitas.ArchetypusIdentitas

object RegistrumArchetypi {

    fun omnia(): Collection<Archetypus> = RegistraArchetypi.omnia()
    fun invenire(identitas: ArchetypusIdentitas): Archetypus = RegistraArchetypi.invenirePerClavemNecesse(identitas)
}