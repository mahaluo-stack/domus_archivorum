package ars_disciplina.registrum.nexuum

import ars_disciplina.commune.registra.RegistraMusculi
import ars_disciplina.commune.registra.RegistraMusculiMusculiRegio
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.nexuum.tabula.MusculiMusculiRegio
import org.example.exemplaria.tabulae.Musculi

class RegistrumMusculiMusculiRegio {
    fun omnia(): Collection<MusculiMusculiRegio> = RegistraMusculiMusculiRegio.omnia()
    fun invenire(identitas: MusculiIdentitas): MusculiMusculiRegio = RegistraMusculiMusculiRegio.invenirePerClavemNecesse(identitas)
}