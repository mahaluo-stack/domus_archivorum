package translatores.instrumentorum

import ars_disciplina.instrumentorum.tabula.GenusInstrumenti
import commune.contractus.responsa.instrumentorum.ResponsumGenusInstrumenti
import commune.interfacia.InterfaciaTranslatoris

object TranslatorGenusInstrumenti : InterfaciaTranslatoris<GenusInstrumenti, ResponsumGenusInstrumenti> {
    override fun adResponsum(entia: GenusInstrumenti) = ResponsumGenusInstrumenti(
        identitas = entia.genusInstrumentIdentitas,
        nomen = entia.nomen
    )
}