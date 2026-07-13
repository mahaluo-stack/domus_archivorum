package translatores.nexuum

import ars_disciplina.nexuum.tabula.MusculiMusculiPars
import commune.contractus.responsa.nexuum.ResponsumMusculiMusculiPars
import commune.interfacia.InterfaciaTranslatorisAggregationis

object TranslatorMusculiMusculiPars :
    InterfaciaTranslatorisAggregationis<MusculiMusculiPars, ResponsumMusculiMusculiPars> {
    override fun adResponsum(entia: Collection<MusculiMusculiPars>): ResponsumMusculiMusculiPars {
        return ResponsumMusculiMusculiPars(
            musculiIdentitas = entia.first().musculiIdentitas,
            musculiParsIdentitates = entia
                .map { it.musculiParsIdentitas }
                .toSet()
        )
    }
}