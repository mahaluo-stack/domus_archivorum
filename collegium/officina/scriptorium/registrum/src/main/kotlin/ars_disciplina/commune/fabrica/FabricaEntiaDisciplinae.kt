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
import org.example.commune.registrum.RegistraAngulus
import org.example.commune.registrum.RegistraDisciplinae
import org.example.commune.registrum.RegistraMotus
import org.example.commune.registrum.RegistraVariationes

object FabricaEntiaDisciplinae {
    fun creaOmnes(
        identitates: Set<DisciplinaeIdentitas>
    ): Set<EntiaDisciplina> = identitates.mapTo(mutableSetOf()) {
        crea(it)
    }

    fun crea(disciplinaeIdentitas: DisciplinaeIdentitas): EntiaDisciplina {
        val generaDisciplinae = RegistraDisciplinaGeneraDisciplinae.invenirePerClavemNecesse(disciplinaeIdentitas)
        val motus = RegistraDisciplinaMotus.invenirePerClavemNecesse(disciplinaeIdentitas)
        val modusOneris = RegistraDisciplinaModiOneris.omniaPerClavemNecesse(disciplinaeIdentitas)
            .map { it.modusOnerisIdentitas }
            .toSet()
        val lateralis = RegistraDisciplinaLateralitates.omniaPerClavemNecesse(disciplinaeIdentitas)
            .map { it.lateralisIdentitas }
            .toSet()
        val variationes = RegistraDisciplinaVariationes.omniaPerClavemNecesse(disciplinaeIdentitas)
            .map { it.variationesIdentitas }
            .toSet()
        val angulus = RegistraDisciplinaAnguli.omniaPerClavemNecesse(disciplinaeIdentitas)
            .map { it.angulusIdentitas }
            .toSet()
        val prehensiones = RegistraDisciplinaPrehensiones.omniaPerClavemNecesse(disciplinaeIdentitas)
            .map { it.prehensionesIdentitas }
            .toSet()
        val generaPrehensionis = RegistraDisciplinaGeneraPrehensionis.omniaPerClavemNecesse(disciplinaeIdentitas)
            .map { it.generaPrehensionisIdentitas }
            .toSet()

        val musculiPars = RegistraDisciplinaMusculiPars.omniaPerClavemNecesse(disciplinaeIdentitas)
            .map { it.musculiParsIdentitas }
            .toSet()

        val musculi = RegistraMusculiMusculiPars.omnia()
            .filter { musculiPars.contains(it.musculiParsIdentitas) }
            .map { it.musculiIdentitas }
            .toSet()

        val musculiRegio = RegistraMusculiRegioMusculi.omnia()
            .filter { musculi.contains(it.musculiIdentitas) }
            .map { it.musculiRegioIdentitas }
            .toSet()

        val instrumenti = RegistraDisciplinaInstrumenti.omniaPerClavemNecesse(disciplinaeIdentitas)
            .map { it.instrumentaIdentitas }
            .toSet()
        val genusInstrumenti = RegistraDisciplinaGeneraInstrumenti.omniaPerClavemNecesse(disciplinaeIdentitas)
            .map { it.genusInstrumentiIdentitas }
            .toSet()


        return EntiaDisciplina(
            disciplinae = RegistraDisciplinae.invenirePerClavemNecesse(disciplinaeIdentitas),
            generaDisciplinae = RegistraGeneraDisciplinae.invenirePerClavemNecesse(generaDisciplinae.generaDisciplinaeIdentitas),
            motus = RegistraMotus.invenirePerClavemNecesse(motus.motusIdentitas),

            modusOneris = RegistraModusOneris.omniaPerClaves(modusOneris),
            lateralis = RegistraLateralis.omniaPerClaves(lateralis),
            variationes = RegistraVariationes.omniaPerClaves(variationes),
            angulus = RegistraAngulus.omniaPerClaves(angulus),

            prehensiones = RegistraPrehensiones.omniaPerClaves(prehensiones),
            generaPrehensiones = RegistraGeneraPrehensionis.omniaPerClaves(generaPrehensionis),

            musculiRegio = RegistraMusculiRegio.omniaPerClaves(musculiRegio),
            musculi = RegistraMusculi.omniaPerClaves(musculi),
            musculiPars = RegistraMusculiPars.omniaPerClaves(musculiPars),
            instrumenta = RegistraInstrumenti.omniaPerClaves(instrumenti),
            genusInstrumenti = RegistraGeneraInstrumenti.omniaPerClaves(genusInstrumenti)
        )
    }
}