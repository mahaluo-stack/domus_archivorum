package ars_disciplina.registrum.instrumentorum

import ars_disciplina.commune.registra.RegistraGeneraInstrumenti
import ars_disciplina.instrumentorum.tabula.GenusInstrumenti
import ars_disciplina.instrumentorum.valores.identitas.GenusInstrumentiIdentitas

object RegistrumGenusInstrumenti {

    fun omnia(): Collection<GenusInstrumenti> = RegistraGeneraInstrumenti.omnia()
    fun invenire(identitas: GenusInstrumentiIdentitas): GenusInstrumenti = RegistraGeneraInstrumenti.invenirePerClavemNecesse(identitas)
}