package ars_disciplina.registrum.musculorum

import ars_disciplina.commune.registra.RegistraMusculi
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import org.example.exemplaria.tabulae.Musculi

object RegistrumMusculi {

    fun omnia(): Collection<Musculi> = RegistraMusculi.omnia()
    fun invenire(identitas: MusculiIdentitas): Musculi = RegistraMusculi.invenirePerClavemNecesse(identitas)
}