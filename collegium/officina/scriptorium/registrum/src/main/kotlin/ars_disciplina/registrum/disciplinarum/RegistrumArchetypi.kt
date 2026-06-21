package ars_disciplina.registrum.disciplinarum

import ars_disciplina.commune.registra.RegistraArchetypi
import ars_disciplina.disciplinarum.tabula.Angulus
import ars_disciplina.disciplinarum.tabula.Archetypus
import ars_disciplina.disciplinarum.valores.identitas.AngulusIdentitas
import ars_disciplina.disciplinarum.valores.identitas.ArchetypusIdentitas
import ars_disciplina.registrum.Registrum

object RegistrumArchetypi : Registrum<ArchetypusIdentitas, Archetypus>() {

    override fun omnia(): Collection<Archetypus> = RegistraArchetypi.omnia()
    override fun invenire(identitas: ArchetypusIdentitas): Archetypus = RegistraArchetypi.invenirePerClavemNecesse(identitas)
}