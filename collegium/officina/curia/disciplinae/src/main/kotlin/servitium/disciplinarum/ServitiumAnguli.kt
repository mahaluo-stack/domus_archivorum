package servitium.disciplinarum

import ars_disciplina.disciplinarum.tabula.Angulus
import ars_disciplina.disciplinarum.valores.identitas.AngulusIdentitas
import ars_disciplina.registrum.disciplinarum.RegistrumAngulus
import commune.contractus.responsa.disciplinarum.ResponsumAnguli
import servitium.ServitiumLecturae
import translatores.disciplinarum.TranslatorAngulus

object ServitiumAnguli : ServitiumLecturae<AngulusIdentitas, Angulus, ResponsumAnguli>() {

    override fun omniaEntia() = RegistrumAngulus.omnia()
    override fun invenireEntia(identitas: AngulusIdentitas) = RegistrumAngulus.invenirePerClavemNecesse(identitas)
    override fun adResponsum(entia: Angulus): ResponsumAnguli = TranslatorAngulus.adResponsum(entia)
}