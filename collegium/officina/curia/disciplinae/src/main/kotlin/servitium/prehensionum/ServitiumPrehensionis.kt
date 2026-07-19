package servitium.prehensionum

import ars_disciplina.prehensionum.tabula.Prehensiones
import ars_disciplina.prehensionum.valores.identitas.PrehensionesIdentitas
import ars_disciplina.registrum.prehensionum.RegistrumPreheniones
import commune.contractus.responsa.prehensionum.ResponsumPrehensiones
import servitium.ServitiumLecturae
import translatores.prehensionum.TranslatorPrehensiones

object ServitiumPrehensionis : ServitiumLecturae<PrehensionesIdentitas, Prehensiones, ResponsumPrehensiones>() {

    override fun omniaEntia() = RegistrumPreheniones.omnia()
    override fun invenireEntia(identitas: PrehensionesIdentitas) = RegistrumPreheniones.invenirePerClavemNecesse(identitas)
    override fun adResponsum(entia: Prehensiones): ResponsumPrehensiones = TranslatorPrehensiones.adResponsum(entia)
}