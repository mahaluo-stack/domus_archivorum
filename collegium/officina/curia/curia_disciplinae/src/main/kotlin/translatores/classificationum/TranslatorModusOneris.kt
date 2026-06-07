package translatores.classificationum

import ars_disciplina.classificationum.tabula.ModusOneris
import commune.contractus.responsa.classificationum.ResponsumModusOneris
import commune.interfacia.InterfaciaTranslatoris

object TranslatorModusOneris : InterfaciaTranslatoris<ModusOneris, ResponsumModusOneris> {
    override fun adResponsum(entia: ModusOneris) = ResponsumModusOneris(
        identitas = entia.modusOnerisIdentitas,
        nomen = entia.nomen
    )
}