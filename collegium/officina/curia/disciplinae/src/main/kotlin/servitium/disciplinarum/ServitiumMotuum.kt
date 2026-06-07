package servitium.disciplinarum

import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import ars_disciplina.registrum.disciplinarum.RegistrumMotuum
import commune.contractus.responsa.disciplinarum.ResponsumMotuum
import servitium.ServitiumLecturae
import translatores.disciplinarum.TranslatorMotuum

object ServitiumMotuum : ServitiumLecturae<MotusIdentitas, Motus, ResponsumMotuum>() {

    override fun omniaEntia() = RegistrumMotuum.omnia()
    override fun invenireEntia(identitas: MotusIdentitas) = RegistrumMotuum.invenire(identitas)
    override fun adResponsum(entia: Motus) = TranslatorMotuum.adResponsum(entia)
}