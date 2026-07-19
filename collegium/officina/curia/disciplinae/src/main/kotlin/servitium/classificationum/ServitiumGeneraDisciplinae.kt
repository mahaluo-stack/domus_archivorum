package servitium.classificationum

import ars_disciplina.classificationum.tabula.GeneraDisciplinae
import ars_disciplina.classificationum.valores.identitas.GeneraDisciplinaeIdentitas
import ars_disciplina.registrum.classificationum.RegistrumGeneraDisciplinae
import commune.contractus.responsa.classificationum.ResponsumGeneraDisciplinae
import servitium.ServitiumLecturae
import translatores.classificationum.TranslatorGeneraDisciplinae

object ServitiumGeneraDisciplinae : ServitiumLecturae<GeneraDisciplinaeIdentitas, GeneraDisciplinae, ResponsumGeneraDisciplinae>() {

    override fun omniaEntia() = RegistrumGeneraDisciplinae.omnia()
    override fun invenireEntia(identitas: GeneraDisciplinaeIdentitas) = RegistrumGeneraDisciplinae.invenirePerClavemNecesse(identitas)
    override fun adResponsum(entia: GeneraDisciplinae): ResponsumGeneraDisciplinae = TranslatorGeneraDisciplinae.adResponsum(entia)
}