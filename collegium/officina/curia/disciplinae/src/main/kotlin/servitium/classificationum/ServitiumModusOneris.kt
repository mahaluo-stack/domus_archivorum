package servitium.classificationum

import ars_disciplina.classificationum.tabula.ModusOneris
import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas
import ars_disciplina.registrum.classificationum.RegistrumModusOneris
import commune.contractus.responsa.classificationum.ResponsumModusOneris
import servitium.ServitiumLecturae
import translatores.classificationum.TranslatorModusOneris

object ServitiumModusOneris : ServitiumLecturae<ModusOnerisIdentitas, ModusOneris, ResponsumModusOneris>() {

    override fun omniaEntia() = RegistrumModusOneris.omnia()
    override fun invenireEntia(identitas: ModusOnerisIdentitas) = RegistrumModusOneris.invenirePerClavemNecesse(identitas)
    override fun adResponsum(entia: ModusOneris): ResponsumModusOneris = TranslatorModusOneris.adResponsum(entia)
}