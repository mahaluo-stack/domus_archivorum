package translatores.disciplinarum

import ars_disciplina.disciplinarum.tabula.Angulus
import commune.contractus.responsa.disciplinarum.ResponsumAnguli
import commune.interfacia.InterfaciaTranslatoris

object TranslatorAngulus : InterfaciaTranslatoris<Angulus, ResponsumAnguli> {
    override fun adResponsum(entia: Angulus) = ResponsumAnguli(
        identitas = entia.angulusIdentitas,
        anguli = entia.angulus
    )
}