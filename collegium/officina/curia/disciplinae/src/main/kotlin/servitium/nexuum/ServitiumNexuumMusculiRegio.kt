package servitium.nexuum

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import ars_disciplina.nexuum.MinisteriumMusculiMusculiRegio
import ars_disciplina.nexuum.tabula.MusculiMusculiRegio
import ars_disciplina.registrum.nexuum.RegistrumMusculiMusculiRegio
import commune.contractus.responsa.nexuum.ResponsumMusculiMusculiRegio
import servitium.ServitiumLecturae
import translatores.nexuum.TranslatorMusculiMusculiRegio

object ServitiumNexuumMusculiRegio : ServitiumLecturae<MusculiIdentitas, MusculiMusculiRegio, ResponsumMusculiMusculiRegio>() {

    override fun omniaEntia() = RegistrumMusculiMusculiRegio.omnia()
    override fun invenireEntia(identitas: MusculiIdentitas) = RegistrumMusculiMusculiRegio.invenire(identitas)
    override fun adResponsum(entia: MusculiMusculiRegio): ResponsumMusculiMusculiRegio = TranslatorMusculiMusculiRegio.adResponsum(entia)

    fun ponere(
        musculiIdentitas: MusculiIdentitas,
        musculiRegioIdentitas: MusculiRegioIdentitas
    ) {
        MinisteriumMusculiMusculiRegio.ponere(
            musculiIdentitas,
            musculiRegioIdentitas
        )
    }
}