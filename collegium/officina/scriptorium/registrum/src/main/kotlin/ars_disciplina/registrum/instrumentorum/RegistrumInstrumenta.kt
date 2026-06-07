package ars_disciplina.registrum.instrumentorum

import ars_disciplina.commune.registra.RegistraInstrumenti
import ars_disciplina.instrumentorum.tabula.Instrumenta
import ars_disciplina.instrumentorum.valores.identitas.InstrumentaIdentitas

object RegistrumInstrumenta {

    fun omnia(): Collection<Instrumenta> = RegistraInstrumenti.omnia()
    fun invenire(identitas: InstrumentaIdentitas): Instrumenta = RegistraInstrumenti.invenirePerClavemNecesse(identitas)
}