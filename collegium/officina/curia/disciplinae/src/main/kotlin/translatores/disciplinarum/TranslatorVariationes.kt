package translatores.disciplinarum

import ars_disciplina.disciplinarum.tabula.Variationes
import commune.contractus.responsa.disciplinarum.ResponsumVariationes
import commune.interfacia.InterfaciaTranslatoris

object TranslatorVariationes : InterfaciaTranslatoris<Variationes, ResponsumVariationes> {
    override fun adResponsum(entia: Variationes) = ResponsumVariationes(
        identitas = entia.variationesIdentitas,
        nomen = entia.nomen
    )
}