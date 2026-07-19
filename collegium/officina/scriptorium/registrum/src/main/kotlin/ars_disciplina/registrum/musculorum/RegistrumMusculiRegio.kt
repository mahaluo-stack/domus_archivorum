package ars_disciplina.registrum.musculorum

import ars_disciplina.commune.registra.catalogus.RegistraMusculiRegio
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import ars_disciplina.registrum.Registrum
import org.example.exemplaria.tabulae.MusculiRegio

object RegistrumMusculiRegio : Registrum<MusculiRegioIdentitas, MusculiRegio>() {

    override fun omnia(): Collection<MusculiRegio> = RegistraMusculiRegio.omnia()
    override fun invenirePerClavemNecesse(identitas: MusculiRegioIdentitas): MusculiRegio = RegistraMusculiRegio.invenirePerClavemNecesse(identitas)
    override fun invenireSiAdest(identitas: MusculiRegioIdentitas): MusculiRegio? = RegistraMusculiRegio.invenireSiAdest(identitas)
}