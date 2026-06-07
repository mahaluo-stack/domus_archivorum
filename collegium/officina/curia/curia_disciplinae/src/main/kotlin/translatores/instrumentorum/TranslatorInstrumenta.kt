package translatores.instrumentorum

import ars_disciplina.instrumentorum.tabula.Instrumenta
import commune.contractus.responsa.instrumentorum.ResponsumInstrumenta
import commune.interfacia.InterfaciaTranslatoris

object TranslatorInstrumenta : InterfaciaTranslatoris<Instrumenta, ResponsumInstrumenta> {
    override fun adResponsum(entia: Instrumenta) = ResponsumInstrumenta(
        identitas = entia.instrumentaIdentitas,
        nomen = entia.nomen,
        descriptio = entia.descriptio
    )
}