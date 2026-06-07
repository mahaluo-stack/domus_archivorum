package translatores.disciplinarum

import ars_disciplina.disciplinarum.tabula.Motus
import commune.contractus.responsa.disciplinarum.ResponsumMotuum
import commune.interfacia.InterfaciaTranslatoris

object TranslatorMotuum : InterfaciaTranslatoris<Motus, ResponsumMotuum> {
    override fun adResponsum(entia: Motus) = ResponsumMotuum(
        identitas = entia.motusIdentitas,
        nomen = entia.nomen,
        descriptio = entia.descriptio,
    )
}