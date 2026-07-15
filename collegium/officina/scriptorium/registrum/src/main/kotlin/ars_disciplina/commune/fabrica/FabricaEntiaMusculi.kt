package ars_disciplina.commune.fabrica

import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaAnguli
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaGeneraDisciplinae
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaGeneraInstrumenti
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaGeneraPrehensionis
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaInstrumenti
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaLateralitates
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaModiOneris
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaMotus
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaMusculiPars
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaPrehensiones
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaVariationes
import ars_disciplina.commune.registra.catalogus.RegistraGeneraDisciplinae
import ars_disciplina.commune.registra.catalogus.RegistraGeneraInstrumenti
import ars_disciplina.commune.registra.catalogus.RegistraGeneraPrehensionis
import ars_disciplina.commune.registra.catalogus.RegistraInstrumenti
import ars_disciplina.commune.registra.catalogus.RegistraLateralis
import ars_disciplina.commune.registra.catalogus.RegistraModusOneris
import ars_disciplina.commune.registra.catalogus.RegistraMusculi
import ars_disciplina.commune.registra.catalogus.RegistraMusculiMusculiPars
import ars_disciplina.commune.registra.catalogus.RegistraMusculiPars
import ars_disciplina.commune.registra.catalogus.RegistraMusculiRegio
import ars_disciplina.commune.registra.catalogus.RegistraMusculiRegioMusculi
import ars_disciplina.commune.registra.catalogus.RegistraPrehensiones
import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import officina.actorum.exemplaria.archivum.EntiaMusculi
import org.example.commune.registrum.RegistraAngulus
import org.example.commune.registrum.RegistraDisciplinae
import org.example.commune.registrum.RegistraMotus
import org.example.commune.registrum.RegistraVariationes

object FabricaEntiaMusculi {
    fun creaOmnes(
        identitates: Set<MusculiIdentitas>
    ): Set<EntiaMusculi> = identitates.mapTo(mutableSetOf()) {
        crea(it)
    }

    fun crea(musculiIdentitas: MusculiIdentitas): EntiaMusculi {
        val musculi = RegistraMusculi.invenirePerClavemNecesse(musculiIdentitas)
        val musculiRegioIdentitas = RegistraMusculiRegioMusculi
            .omnia()
            .first { it.musculiIdentitas == musculiIdentitas }
            .musculiRegioIdentitas
        val musculiRegio = RegistraMusculiRegio.invenirePerClavemNecesse(musculiRegioIdentitas)

        val musculiParsIdentitates = RegistraMusculiMusculiPars
            .omniaPerClavemNecesse(musculiIdentitas)
            .map { it.musculiParsIdentitas }
            .toSet()
       val musculiPars = RegistraMusculiPars.omniaPerClaves(musculiParsIdentitates)

        return EntiaMusculi(
            musculiIdentitas = musculiIdentitas,
            nomenMusculi = musculi.nomen,
            descriptioMusculi = musculi.descriptio,
            musculiRegio = musculiRegio,
            musculiPars = musculiPars
        )
    }
}