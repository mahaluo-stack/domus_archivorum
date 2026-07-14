package ars_disciplina

import ars_disciplina.classificationum.DepositumGeneraDisciplinae
import ars_disciplina.commune.registra.InterfaciaRegistri
import ars_disciplina.commune.registra.RegistraNexuum
import ars_disciplina.commune.registra.catalogus.RegistraArchetypi
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaAnguli
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaArchetypi
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaGeneraDisciplinae
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaGeneraInstrumenti
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaGeneraPrehensionis
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaInstrumenti
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaLateralitates
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaModiOneris
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaMotus
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaMusculiPars
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaPrehensiones
import ars_disciplina.commune.registra.catalogus.RegistraDisciplinaRegulae
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
import ars_disciplina.commune.registra.catalogus.RegistraRegulae
import ars_disciplina.disciplinarum.DepositumArchetypi
import ars_disciplina.musculorum.DepositumMusculi
import ars_disciplina.musculorum.DepositumMusculiPars
import ars_disciplina.musculorum.DepositumMusculiRegio
import ars_disciplina.nexuum.DepositumDisciplinaAnguliDisciplinae
import ars_disciplina.nexuum.DepositumDisciplinaArchetypiDisciplinae
import ars_disciplina.nexuum.DepositumDisciplinaGeneraDisciplinaeDisciplinae
import ars_disciplina.nexuum.DepositumDisciplinaGeneraInstrumentiDisciplinae
import ars_disciplina.nexuum.DepositumDisciplinaGeneraPrehensionisDisciplinae
import ars_disciplina.nexuum.DepositumDisciplinaInstrumentiDisciplinae
import ars_disciplina.nexuum.DepositumDisciplinaLateralitatesDisciplinae
import ars_disciplina.nexuum.DepositumDisciplinaModiOnerisDisciplinae
import ars_disciplina.nexuum.DepositumDisciplinaMotusDisciplinae
import ars_disciplina.nexuum.DepositumDisciplinaMusculiParsDisciplinae
import ars_disciplina.nexuum.DepositumDisciplinaPrehensionesDisciplinae
import ars_disciplina.nexuum.DepositumDisciplinaRegulaeDisciplinae
import ars_disciplina.nexuum.DepositumDisciplinaVariationesDisciplinae
import ars_disciplina.nexuum.DepositumMusculiMusculiPars
import ars_disciplina.nexuum.DepositumMusculiRegioMusculi
import ars_disciplina.regularum.DepositumRegulae
import org.example.commune.registrum.Registra
import org.example.commune.registrum.RegistraAngulus
import org.example.commune.registrum.RegistraDisciplinae
import org.example.commune.registrum.RegistraMotus
import org.example.commune.registrum.RegistraVariationes
import org.example.disciplinarum.depositum.DepositumAngulus
import org.example.disciplinarum.depositum.DepositumDisciplinae
import org.example.disciplinarum.depositum.DepositumGeneraPrehensionis
import org.example.disciplinarum.depositum.DepositumLateralis
import org.example.disciplinarum.depositum.DepositumModusOneris
import org.example.disciplinarum.depositum.DepositumMotus
import org.example.disciplinarum.depositum.DepositumPrehensiones
import org.example.disciplinarum.depositum.DepositumVariationes
import org.example.instrumentorum.depositum.DepositumGeneraInstrumenti
import org.example.instrumentorum.depositum.DepositumInstrumenta

object RenovatorRegistrorum {

    private data class Renovatio<T>(
        val registra: InterfaciaRegistri<T>,
        val depositum: Depositum<T>
    )

    private val renovationes = listOf(
        Renovatio(RegistraGeneraDisciplinae, DepositumGeneraDisciplinae),
        Renovatio(RegistraLateralis, DepositumLateralis),
        Renovatio(RegistraModusOneris, DepositumModusOneris),
        Renovatio(RegistraAngulus, DepositumAngulus),
        Renovatio(RegistraArchetypi, DepositumArchetypi),
        Renovatio(RegistraDisciplinae, DepositumDisciplinae),
        Renovatio(RegistraVariationes, DepositumVariationes),
        Renovatio(RegistraMotus, DepositumMotus),
        Renovatio(RegistraGeneraInstrumenti, DepositumGeneraInstrumenti),
        Renovatio(RegistraInstrumenti, DepositumInstrumenta),
        Renovatio(RegistraMusculi, DepositumMusculi),
        Renovatio(RegistraMusculiPars, DepositumMusculiPars),
        Renovatio(RegistraMusculiRegio, DepositumMusculiRegio),
        Renovatio(RegistraDisciplinaAnguli, DepositumDisciplinaAnguliDisciplinae),
        Renovatio(RegistraDisciplinaArchetypi, DepositumDisciplinaArchetypiDisciplinae),
        Renovatio(RegistraDisciplinaGeneraDisciplinae, DepositumDisciplinaGeneraDisciplinaeDisciplinae),
        Renovatio(RegistraDisciplinaGeneraInstrumenti, DepositumDisciplinaGeneraInstrumentiDisciplinae),
        Renovatio(RegistraDisciplinaGeneraPrehensionis, DepositumDisciplinaGeneraPrehensionisDisciplinae),
        Renovatio(RegistraDisciplinaInstrumenti, DepositumDisciplinaInstrumentiDisciplinae),
        Renovatio(RegistraDisciplinaLateralitates, DepositumDisciplinaLateralitatesDisciplinae),
        Renovatio(RegistraDisciplinaModiOneris, DepositumDisciplinaModiOnerisDisciplinae),
        Renovatio(RegistraDisciplinaMotus, DepositumDisciplinaMotusDisciplinae),
        Renovatio(RegistraDisciplinaMusculiPars, DepositumDisciplinaMusculiParsDisciplinae),
        Renovatio(RegistraDisciplinaPrehensiones, DepositumDisciplinaPrehensionesDisciplinae),
        Renovatio(RegistraDisciplinaRegulae, DepositumDisciplinaRegulaeDisciplinae),
        Renovatio(RegistraDisciplinaVariationes, DepositumDisciplinaVariationesDisciplinae),
        Renovatio(RegistraMusculiMusculiPars, DepositumMusculiMusculiPars),
        Renovatio(RegistraMusculiRegioMusculi, DepositumMusculiRegioMusculi),
        Renovatio(RegistraPrehensiones, DepositumPrehensiones),
        Renovatio(RegistraGeneraPrehensionis, DepositumGeneraPrehensionis),
        Renovatio(RegistraRegulae, DepositumRegulae)
    )

    fun initializaRegistrum() {
        renovationes.forEach { renovatio ->
            renova(renovatio)
        }
    }

    fun <T> renova(registra: InterfaciaRegistri<T>) {

        val renovatio = renovationes
            .first { it.registra == registra } as Renovatio<T>

        renova(renovatio)
    }

    private fun <T> renova(renovatio: Renovatio<T>) {

        renovatio.registra.initializa(
            renovatio.depositum.legeOmnes()
        )

    }
}