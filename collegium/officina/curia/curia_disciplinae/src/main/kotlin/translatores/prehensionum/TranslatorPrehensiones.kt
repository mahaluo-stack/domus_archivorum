package translatores.prehensionum

import ars_disciplina.prehensionum.tabula.Prehensiones
import commune.contractus.responsa.prehensionum.ResponsumPrehensiones
import commune.interfacia.InterfaciaTranslatoris

object TranslatorPrehensiones : InterfaciaTranslatoris<Prehensiones, ResponsumPrehensiones> {
    override fun adResponsum(entia: Prehensiones) = ResponsumPrehensiones(
        identitas = entia.prehensionesIdentitas,
        nomen = entia.nomen,
        descriptio = entia.descriptio
    )
}