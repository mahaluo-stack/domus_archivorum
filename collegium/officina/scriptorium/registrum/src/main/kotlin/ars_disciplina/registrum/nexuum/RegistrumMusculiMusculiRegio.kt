package ars_disciplina.registrum.nexuum

import ars_disciplina.commune.registra.RegistraMusculiMusculiRegio
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.nexuum.tabula.MusculiMusculiRegio
import ars_disciplina.registrum.Registrum

object RegistrumMusculiMusculiRegio : Registrum<MusculiIdentitas, MusculiMusculiRegio>()  {
    override fun omnia(): Collection<MusculiMusculiRegio> = RegistraMusculiMusculiRegio.omnia()
    override fun invenire(identitas: MusculiIdentitas): MusculiMusculiRegio = RegistraMusculiMusculiRegio.invenirePerClavemNecesse(identitas)
}