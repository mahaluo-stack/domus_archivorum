package translatores.nexuum

import ars_disciplina.nexuum.tabula.MusculiRegioMusculi
import commune.contractus.responsa.nexuum.ResponsumMusculiMusculiPars
import commune.contractus.responsa.nexuum.ResponsumMusculiRegioMusculi
import commune.interfacia.InterfaciaTranslatoris
import commune.interfacia.InterfaciaTranslatorisAggregationis
import kotlin.collections.first
import kotlin.collections.map

object TranslatorMusculiMusculiRegio :
    InterfaciaTranslatorisAggregationis<MusculiRegioMusculi, ResponsumMusculiRegioMusculi> {
    override fun adResponsum(entia: Collection<MusculiRegioMusculi>): ResponsumMusculiRegioMusculi {
        return ResponsumMusculiRegioMusculi(
            musculiRegioIdentitas = entia.first().musculiRegioIdentitas,
            musculiIdentitates = entia
                .map { it.musculiIdentitas }
                .toSet()
        )
    }
}