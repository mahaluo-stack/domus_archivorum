package servitium.instrumentorum

import ars_disciplina.instrumentorum.tabula.Instrumenta
import ars_disciplina.instrumentorum.valores.identitas.InstrumentaIdentitas
import ars_disciplina.registrum.instrumentorum.RegistrumInstrumenta
import commune.contractus.responsa.instrumentorum.ResponsumInstrumenta
import servitium.ServitiumLecturae
import translatores.instrumentorum.TranslatorInstrumenta

object ServitiumInstrumenta : ServitiumLecturae<InstrumentaIdentitas, Instrumenta, ResponsumInstrumenta>() {

    override fun omniaEntia() = RegistrumInstrumenta.omnia()
    override fun invenireEntia(identitas: InstrumentaIdentitas) = RegistrumInstrumenta.invenirePerClavemNecesse(identitas)
    override fun adResponsum(entia: Instrumenta): ResponsumInstrumenta = TranslatorInstrumenta.adResponsum(entia)
}