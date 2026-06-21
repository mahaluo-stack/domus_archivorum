package ars_disciplina.registrum.nexuum

import ars_disciplina.commune.registra.RegistraMusculiMusculiRegio
import ars_disciplina.commune.registra.RegistraMusculiParsMusculi
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.nexuum.tabula.MusculiMusculiRegio
import ars_disciplina.nexuum.tabula.MusculiParsMusculi

class RegistrumMusculiParsMusculi {
    fun omnia(): Collection<MusculiParsMusculi> = RegistraMusculiParsMusculi.omnia()
    fun invenire(identitas: MusculiParsIdentitas): MusculiParsMusculi = RegistraMusculiParsMusculi.invenirePerClavemNecesse(identitas)
}