package ars_disciplina.registrum.instrumentorum

import ars_disciplina.commune.registra.catalogus.RegistraInstrumenti
import ars_disciplina.instrumentorum.tabula.Instrumenta
import ars_disciplina.instrumentorum.valores.identitas.InstrumentaIdentitas
import ars_disciplina.registrum.Registrum

object RegistrumInstrumenta : Registrum<InstrumentaIdentitas, Instrumenta>()  {

    override fun omnia(): Collection<Instrumenta> = RegistraInstrumenti.omnia()
    override fun invenire(identitas: InstrumentaIdentitas): Instrumenta = RegistraInstrumenti.invenirePerClavemNecesse(identitas)
}