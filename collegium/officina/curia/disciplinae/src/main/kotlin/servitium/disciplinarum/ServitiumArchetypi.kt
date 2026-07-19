package servitium.disciplinarum

import ars_disciplina.disciplinarum.tabula.Archetypus
import ars_disciplina.disciplinarum.valores.identitas.ArchetypusIdentitas
import ars_disciplina.registrum.disciplinarum.RegistrumArchetypi
import commune.contractus.responsa.disciplinarum.ResponsumArchetypi
import servitium.ServitiumLecturae
import translatores.disciplinarum.TranslatorArchetypi

object ServitiumArchetypi : ServitiumLecturae<ArchetypusIdentitas, Archetypus, ResponsumArchetypi>() {

    override fun omniaEntia() = RegistrumArchetypi.omnia()
    override fun invenireEntia(identitas: ArchetypusIdentitas) = RegistrumArchetypi.invenirePerClavemNecesse(identitas)
    override fun adResponsum(entia: Archetypus): ResponsumArchetypi = TranslatorArchetypi.adResponsum(entia)
}