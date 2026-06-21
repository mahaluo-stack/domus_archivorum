package translatores.nexuum

import ars_disciplina.nexuum.tabula.MusculiMusculiRegio
import commune.contractus.responsa.nexuum.ResponsumMusculiMusculiRegio
import commune.interfacia.InterfaciaTranslatoris

object TranslatorMusculiMusculiRegio : InterfaciaTranslatoris<MusculiMusculiRegio, ResponsumMusculiMusculiRegio> {
    override fun adResponsum(entia: MusculiMusculiRegio) = ResponsumMusculiMusculiRegio(
        musculiIdentitas = entia.musculiIdentitas,
        musculiRegioIdentitas = entia.musculiRegioIdentitas
    )
}