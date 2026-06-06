package translatores.disciplinarum

import ars_disciplina.disciplinarum.tabula.Archetypus
import commune.contractus.responsa.disciplinarum.ResponsumArchetypi
import commune.interfacia.InterfaciaTranslatoris

object TranslatorArchetypi : InterfaciaTranslatoris<Archetypus, ResponsumArchetypi> {
    override fun adResponsum(entia: Archetypus) = ResponsumArchetypi(
        identitas = entia.archetypiIdentitas,
        nomen = entia.nomenArchetypi,
        descriptio = entia.descriptio
    )
}