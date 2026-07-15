package servitium.entia

import ars_disciplina.commune.fabrica.FabricaEntiaMusculi
import ars_disciplina.commune.registra.catalogus.RegistraMusculiMusculiPars
import ars_disciplina.commune.registra.catalogus.RegistraMusculiRegioMusculi
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import commune.contractus.responsa.entia.ResponsumEntiaMusculi
import officina.actorum.exemplaria.archivum.EntiaMusculi
import servitium.ServitiumLecturaeEntia
import translatores.entia.TranslatorEntiaMusculi

object ServitiumEntiaMusculi : ServitiumLecturaeEntia<MusculiIdentitas, EntiaMusculi, ResponsumEntiaMusculi>() {

    override fun omniaEntia(): Collection<EntiaMusculi> {
        val musculiCumPartibus = RegistraMusculiMusculiPars
            .omnia()
            .map { it.musculiIdentitas }
            .toSet()

        val musculiCumRegione = RegistraMusculiRegioMusculi
            .omnia()
            .map { it.musculiIdentitas }
            .toSet()

        return (musculiCumPartibus intersect musculiCumRegione).map(FabricaEntiaMusculi::crea)
    }

    override fun invenireEntia(identitas: MusculiIdentitas): EntiaMusculi {
        return FabricaEntiaMusculi.crea(identitas)
    }

    override fun adResponsum(entia: EntiaMusculi): ResponsumEntiaMusculi {
        return TranslatorEntiaMusculi.adResponsum(entia)
    }
}