package translatores.classificationum

import ars_disciplina.classificationum.tabula.Lateralis
import commune.contractus.responsa.classificationum.ResponsumLateralis
import commune.interfacia.InterfaciaTranslatoris

object TranslatorLateralis : InterfaciaTranslatoris<Lateralis, ResponsumLateralis> {
    override fun adResponsum(entia: Lateralis) = ResponsumLateralis(
        identitas = entia.lateralisIdentitas,
        nomen = entia.nomen
    )
}