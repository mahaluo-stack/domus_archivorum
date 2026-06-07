package ars_disciplina.registrum.musculorum

import ars_disciplina.commune.registra.RegistraMusculiRegio
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import org.example.exemplaria.tabulae.MusculiRegio

object RegistrumMusculiRegio {

    fun omnia(): Collection<MusculiRegio> = RegistraMusculiRegio.omnia()
    fun invenire(identitas: MusculiRegioIdentitas): MusculiRegio = RegistraMusculiRegio.invenirePerClavemNecesse(identitas)
}