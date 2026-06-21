package servitium.nexuum

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.nexuum.MinisteriumMusculiParsMusculi
import ars_disciplina.nexuum.tabula.MusculiParsMusculi
import ars_disciplina.registrum.nexuum.RegistrumMusculiParsMusculi
import commune.contractus.responsa.nexuum.ResponsumMusculiParsMusculi
import servitium.ServitiumLecturae
import translatores.nexuum.TranslatorMusculiParsMusculi

object ServitiumMusculiParsMusculi : ServitiumLecturae<MusculiParsIdentitas, MusculiParsMusculi, ResponsumMusculiParsMusculi>() {

    override fun omniaEntia() = RegistrumMusculiParsMusculi.omnia()
    override fun invenireEntia(identitas: MusculiParsIdentitas) = RegistrumMusculiParsMusculi.invenire(identitas)
    override fun adResponsum(entia: MusculiParsMusculi): ResponsumMusculiParsMusculi = TranslatorMusculiParsMusculi.adResponsum(entia)

    fun ponere(
        musculiParsIdentitas: MusculiParsIdentitas,
        musculiIdentitas: MusculiIdentitas
    ) {
        MinisteriumMusculiParsMusculi.ponere(
            musculiParsIdentitas,
            musculiIdentitas
        )
    }
}