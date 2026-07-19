package ars_disciplina.registrum.instrumentorum

import ars_disciplina.commune.registra.catalogus.RegistraGeneraInstrumenti
import ars_disciplina.instrumentorum.tabula.GenusInstrumenti
import ars_disciplina.instrumentorum.valores.identitas.GenusInstrumentiIdentitas
import ars_disciplina.registrum.Registrum

object RegistrumGenusInstrumenti : Registrum<GenusInstrumentiIdentitas, GenusInstrumenti>()  {

    override fun omnia(): Collection<GenusInstrumenti> = RegistraGeneraInstrumenti.omnia()
    override fun invenirePerClavemNecesse(identitas: GenusInstrumentiIdentitas): GenusInstrumenti = RegistraGeneraInstrumenti.invenirePerClavemNecesse(identitas)
    override fun invenireSiAdest(identitas: GenusInstrumentiIdentitas): GenusInstrumenti? = RegistraGeneraInstrumenti.invenireSiAdest(identitas)
}