package translatores.regularum

import ars_disciplina.regularum.tabula.Regulae
import commune.contractus.responsa.regularum.ResponsumRegulae
import commune.interfacia.InterfaciaTranslatoris

object TranslatorRegulae : InterfaciaTranslatoris<Regulae, ResponsumRegulae> {
    override fun adResponsum(entia: Regulae) = ResponsumRegulae(
        identitas = entia.regulaeIdentitas,
        nomen = entia.nomen,
        genusRegulae = entia.genus,
        descriptio = entia.descriptio
    )
}