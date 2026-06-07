package servitium.musculorum

import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.registrum.musculorum.RegistrumMusculiPars
import commune.contractus.responsa.musculorum.ResponsumMusculiPars
import org.example.exemplaria.tabulae.MusculiPars
import servitium.ServitiumLecturae
import translatores.musculorum.TranslatorMusculiPars

object ServitiumMusculiPars : ServitiumLecturae<MusculiParsIdentitas, MusculiPars, ResponsumMusculiPars>() {

    override fun omniaEntia() = RegistrumMusculiPars.omnia()
    override fun invenireEntia(identitas: MusculiParsIdentitas) = RegistrumMusculiPars.invenire(identitas)
    override fun adResponsum(entia: MusculiPars): ResponsumMusculiPars = TranslatorMusculiPars.adResponsum(entia)
}