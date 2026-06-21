package translatores.nexuum

import ars_disciplina.nexuum.tabula.MusculiParsMusculi
import commune.contractus.responsa.nexuum.ResponsumMusculiParsMusculi
import commune.interfacia.InterfaciaTranslatoris

object TranslatorMusculiParsMusculi : InterfaciaTranslatoris<MusculiParsMusculi, ResponsumMusculiParsMusculi> {
    override fun adResponsum(entia: MusculiParsMusculi) = ResponsumMusculiParsMusculi(
        musculiParsIdentitas = entia.musculiParsIdentitas,
        musculiIdentitas = entia.musculiIdentitas
    )
}