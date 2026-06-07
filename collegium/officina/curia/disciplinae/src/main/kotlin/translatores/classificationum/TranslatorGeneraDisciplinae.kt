package translatores.classificationum

import ars_disciplina.classificationum.tabula.GeneraDisciplinae
import ars_disciplina.classificationum.valores.DescriptioClassificationum
import commune.contractus.responsa.classificationum.ResponsumGeneraDisciplinae
import commune.interfacia.InterfaciaTranslatoris

object TranslatorGeneraDisciplinae : InterfaciaTranslatoris<GeneraDisciplinae, ResponsumGeneraDisciplinae> {
    override fun adResponsum(entia: GeneraDisciplinae) = ResponsumGeneraDisciplinae(
        identitas = entia.generaDisciplinaeIdentitas,
        nomen = entia.nomen,
        descriptio = (entia.descriptio ?: "") as DescriptioClassificationum
    )
}