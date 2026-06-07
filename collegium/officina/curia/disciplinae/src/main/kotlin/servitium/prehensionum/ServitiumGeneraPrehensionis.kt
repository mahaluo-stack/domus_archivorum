package servitium.prehensionum

import ars_disciplina.prehensionum.tabula.GeneraPrehensionis
import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas
import ars_disciplina.registrum.prehensionum.RegistrumGeneraPrehensionis
import commune.contractus.responsa.prehensionum.ResponsumGenusPrehensionis
import servitium.ServitiumLecturae
import translatores.prehensionum.TranslatorGenusPrehensionis

object ServitiumGeneraPrehensionis : ServitiumLecturae<GeneraPrehensionisIdentitas, GeneraPrehensionis, ResponsumGenusPrehensionis>() {

    override fun omniaEntia() = RegistrumGeneraPrehensionis.omnia()
    override fun invenireEntia(identitas: GeneraPrehensionisIdentitas) = RegistrumGeneraPrehensionis.invenire(identitas)
    override fun adResponsum(entia: GeneraPrehensionis): ResponsumGenusPrehensionis = TranslatorGenusPrehensionis.adResponsum(entia)
}