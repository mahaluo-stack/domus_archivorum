package ars_disciplina.registrum.instrumentorum

import ars_disciplina.commune.registra.RegistraInstrumenti
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import ars_disciplina.instrumentorum.tabula.Instrumenta
import ars_disciplina.instrumentorum.valores.identitas.InstrumentaIdentitas
import ars_disciplina.registrum.Registrum

object RegistrumInstrumenta : Registrum<InstrumentaIdentitas, Instrumenta>()  {

    override fun omnia(): Collection<Instrumenta> = RegistraInstrumenti.omnia()
    override fun invenire(identitas: InstrumentaIdentitas): Instrumenta = RegistraInstrumenti.invenirePerClavemNecesse(identitas)
}