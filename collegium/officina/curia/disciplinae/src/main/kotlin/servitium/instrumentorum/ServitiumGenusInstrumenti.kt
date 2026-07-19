package servitium.instrumentorum

import ars_disciplina.instrumentorum.tabula.GenusInstrumenti
import ars_disciplina.instrumentorum.valores.identitas.GenusInstrumentiIdentitas
import ars_disciplina.registrum.instrumentorum.RegistrumGenusInstrumenti
import commune.contractus.responsa.instrumentorum.ResponsumGenusInstrumenti
import servitium.ServitiumLecturae
import translatores.instrumentorum.TranslatorGenusInstrumenti

object ServitiumGenusInstrumenti : ServitiumLecturae<GenusInstrumentiIdentitas, GenusInstrumenti, ResponsumGenusInstrumenti>() {

    override fun omniaEntia() = RegistrumGenusInstrumenti.omnia()
    override fun invenireEntia(identitas: GenusInstrumentiIdentitas) = RegistrumGenusInstrumenti.invenirePerClavemNecesse(identitas)
    override fun adResponsum(entia: GenusInstrumenti): ResponsumGenusInstrumenti = TranslatorGenusInstrumenti.adResponsum(entia)
}