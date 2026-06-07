package translatores.musculorum

import commune.contractus.responsa.musculorum.ResponsumMusculi
import commune.interfacia.InterfaciaTranslatoris
import org.example.exemplaria.tabulae.Musculi

object TranslatorMusculi : InterfaciaTranslatoris<Musculi, ResponsumMusculi> {
    override fun adResponsum(entia: Musculi) = ResponsumMusculi(
        musculiIdentitas = entia.musculiIdentitas,
        musculiRegioIdentitas =entia.musculiRegioIdentitas,
        nomen = entia.nomen,
        descriptio = entia.descriptio
    )
}