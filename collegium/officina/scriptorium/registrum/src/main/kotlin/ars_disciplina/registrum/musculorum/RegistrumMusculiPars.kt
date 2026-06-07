package ars_disciplina.registrum.musculorum

import ars_disciplina.commune.registra.RegistraMusculiPars
import ars_disciplina.commune.registra.RegistraMusculiRegio
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import org.example.exemplaria.tabulae.MusculiPars
import org.example.exemplaria.tabulae.MusculiRegio

object RegistrumMusculiPars {

    fun omnia(): Collection<MusculiPars> = RegistraMusculiPars.omnia()
    fun invenire(identitas: MusculiParsIdentitas): MusculiPars = RegistraMusculiPars.invenirePerClavemNecesse(identitas)
}