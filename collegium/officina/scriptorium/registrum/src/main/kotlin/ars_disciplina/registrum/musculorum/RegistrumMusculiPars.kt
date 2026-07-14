package ars_disciplina.registrum.musculorum

import ars_disciplina.commune.registra.catalogus.RegistraMusculiPars
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.registrum.Registrum
import org.example.exemplaria.tabulae.MusculiPars

object RegistrumMusculiPars : Registrum<MusculiParsIdentitas, MusculiPars>() {

    override fun omnia(): Collection<MusculiPars> = RegistraMusculiPars.omnia()
    override fun invenire(identitas: MusculiParsIdentitas): MusculiPars = RegistraMusculiPars.invenirePerClavemNecesse(identitas)
}