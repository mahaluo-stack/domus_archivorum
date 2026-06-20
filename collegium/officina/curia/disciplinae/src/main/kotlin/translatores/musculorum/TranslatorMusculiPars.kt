package translatores.musculorum

import commune.contractus.responsa.musculorum.ResponsumMusculiPars
import commune.interfacia.InterfaciaTranslatoris
import org.example.exemplaria.tabulae.MusculiPars

object TranslatorMusculiPars : InterfaciaTranslatoris<MusculiPars, ResponsumMusculiPars> {
    override fun adResponsum(entia: MusculiPars) = ResponsumMusculiPars(
        musculiParsIdentitas = entia.musculiParsIdentitas,
        nomen = entia.nomen,
        descriptio = entia.descriptio
    )
}