package translatores.prehensionum

import ars_disciplina.prehensionum.tabula.GeneraPrehensionis
import commune.contractus.responsa.prehensionum.ResponsumGenusPrehensionis
import commune.interfacia.InterfaciaTranslatoris

object TranslatorGenusPrehensionis : InterfaciaTranslatoris<GeneraPrehensionis, ResponsumGenusPrehensionis> {
    override fun adResponsum(entia: GeneraPrehensionis) = ResponsumGenusPrehensionis(
        identitas = entia.generaPrehensionisIdentitas,
        nomen = entia.nomen,
        descriptio = entia.descriptio
    )
}