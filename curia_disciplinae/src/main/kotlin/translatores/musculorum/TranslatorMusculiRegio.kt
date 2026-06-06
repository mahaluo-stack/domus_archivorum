package translatores.musculorum

import commune.contractus.responsa.musculorum.ResponsumMusculiRegio
import commune.interfacia.InterfaciaTranslatoris
import org.example.exemplaria.tabulae.MusculiRegio

object TranslatorMusculiRegio : InterfaciaTranslatoris<MusculiRegio, ResponsumMusculiRegio> {
    override fun adResponsum(entia: MusculiRegio) = ResponsumMusculiRegio(
        musculiRegioIdentitas = entia.musculiRegioIdentitas,
        nomen = entia.nomen,
        descriptio = entia.descriptio
    )
}