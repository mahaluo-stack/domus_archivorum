package servitium.regularum

import ars_disciplina.registrum.regulorum.RegistrumRegulae
import ars_disciplina.regularum.tabula.Regulae
import ars_disciplina.regularum.valores.RegulaeIdentitas
import commune.contractus.responsa.regularum.ResponsumRegulae
import servitium.ServitiumLecturae
import translatores.regularum.TranslatorRegulae

object ServitiumRegulae : ServitiumLecturae<RegulaeIdentitas, Regulae, ResponsumRegulae>() {

    override fun omniaEntia() = RegistrumRegulae.omnia()
    override fun invenireEntia(identitas: RegulaeIdentitas) = RegistrumRegulae.invenire(identitas)
    override fun adResponsum(entia: Regulae): ResponsumRegulae = TranslatorRegulae.adResponsum(entia)
}