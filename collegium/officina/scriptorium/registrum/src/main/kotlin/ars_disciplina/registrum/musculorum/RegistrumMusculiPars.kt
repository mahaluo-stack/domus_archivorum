package ars_disciplina.registrum.musculorum

import ars_disciplina.commune.registra.RegistraMusculiPars
import ars_disciplina.commune.registra.RegistraMusculiRegio
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import ars_disciplina.registrum.Registrum
import org.example.exemplaria.tabulae.MusculiPars
import org.example.exemplaria.tabulae.MusculiRegio

object RegistrumMusculiPars : Registrum<MusculiParsIdentitas, MusculiPars>() {

    override fun omnia(): Collection<MusculiPars> = RegistraMusculiPars.omnia()
    override fun invenire(identitas: MusculiParsIdentitas): MusculiPars = RegistraMusculiPars.invenirePerClavemNecesse(identitas)
}