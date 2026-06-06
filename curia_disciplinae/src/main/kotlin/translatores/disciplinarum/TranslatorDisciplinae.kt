package translatores.disciplinarum

import ars_disciplina.disciplinarum.tabula.Disciplinae
import ars_disciplina.disciplinarum.valores.DescriptioDisciplinae
import commune.contractus.responsa.ResponsumDisciplinae
import commune.interfacia.InterfaciaTranslatoris

object TranslatorDisciplinae : InterfaciaTranslatoris<Disciplinae, ResponsumDisciplinae> {
    override fun adResponsum(entia: Disciplinae) = ResponsumDisciplinae(
        identitas = entia.disciplinaeIdentitas,
        nomen = entia.nomen,
        descriptio = (entia.descriptio ?: "") as DescriptioDisciplinae
    )
}