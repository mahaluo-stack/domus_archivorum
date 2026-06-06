package servitium.musculorum

import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import ars_disciplina.registrum.musculorum.RegistrumMusculiRegio
import commune.contractus.responsa.musculorum.ResponsumMusculiRegio
import org.example.exemplaria.tabulae.MusculiRegio
import servitium.ServitiumLecturae
import translatores.musculorum.TranslatorMusculiRegio

object ServitiumMusculiRegio : ServitiumLecturae<MusculiRegioIdentitas, MusculiRegio, ResponsumMusculiRegio>() {

    override fun omniaEntia() = RegistrumMusculiRegio.omnia()
    override fun invenireEntia(identitas: MusculiRegioIdentitas) = RegistrumMusculiRegio.invenire(identitas)
    override fun adResponsum(entia: MusculiRegio): ResponsumMusculiRegio = TranslatorMusculiRegio.adResponsum(entia)
}