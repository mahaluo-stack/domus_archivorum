package servitium.musculorum

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.registrum.musculorum.RegistrumMusculi
import commune.contractus.responsa.musculorum.ResponsumMusculi
import org.example.exemplaria.tabulae.Musculi
import servitium.ServitiumLecturae
import translatores.musculorum.TranslatorMusculi

object ServitiumMusculi : ServitiumLecturae<MusculiIdentitas, Musculi, ResponsumMusculi>() {

    override fun omniaEntia() = RegistrumMusculi.omnia()
    override fun invenireEntia(identitas: MusculiIdentitas) = RegistrumMusculi.invenire(identitas)
    override fun adResponsum(entia: Musculi): ResponsumMusculi = TranslatorMusculi.adResponsum(entia)
}