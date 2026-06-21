package ars_disciplina.registrum.musculorum

import ars_disciplina.commune.registra.RegistraMusculi
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.registrum.Registrum
import org.example.exemplaria.tabulae.Musculi

object RegistrumMusculi : Registrum<MusculiIdentitas, Musculi>() {

    override fun omnia(): Collection<Musculi> = RegistraMusculi.omnia()
    override fun invenire(identitas: MusculiIdentitas): Musculi = RegistraMusculi.invenirePerClavemNecesse(identitas)
}