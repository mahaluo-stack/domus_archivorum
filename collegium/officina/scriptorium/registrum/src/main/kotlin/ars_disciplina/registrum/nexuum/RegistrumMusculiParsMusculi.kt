package ars_disciplina.registrum.nexuum

import ars_disciplina.commune.registra.RegistraMusculiParsMusculi
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.nexuum.tabula.MusculiParsMusculi
import ars_disciplina.registrum.Registrum

object RegistrumMusculiParsMusculi : Registrum<MusculiParsIdentitas, MusculiParsMusculi>()  {
    override fun omnia(): Collection<MusculiParsMusculi> = RegistraMusculiParsMusculi.omnia()
    override fun invenire(identitas: MusculiParsIdentitas): MusculiParsMusculi = RegistraMusculiParsMusculi.invenirePerClavemNecesse(identitas)
}