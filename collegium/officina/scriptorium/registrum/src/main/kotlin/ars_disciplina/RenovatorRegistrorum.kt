package ars_disciplina

import ars_disciplina.RenovatorRegistrorum.renova
import ars_disciplina.classificationum.DepositumGeneraDisciplinae
import ars_disciplina.commune.registra.RegistraArchetypi
import ars_disciplina.commune.registra.RegistraDisciplinaAnguli
import ars_disciplina.commune.registra.RegistraDisciplinaArchetypi
import ars_disciplina.commune.registra.RegistraDisciplinaGeneraDisciplinae
import ars_disciplina.commune.registra.RegistraDisciplinaGeneraInstrumenti
import ars_disciplina.commune.registra.RegistraDisciplinaGeneraPrehensionis
import ars_disciplina.commune.registra.RegistraDisciplinaInstrumenti
import ars_disciplina.commune.registra.RegistraDisciplinaLateralitates
import ars_disciplina.commune.registra.RegistraDisciplinaModiOneris
import ars_disciplina.commune.registra.RegistraDisciplinaMotus
import ars_disciplina.commune.registra.RegistraDisciplinaMusculiPars
import ars_disciplina.commune.registra.RegistraDisciplinaPrehensiones
import ars_disciplina.commune.registra.RegistraDisciplinaRegulae
import ars_disciplina.commune.registra.RegistraDisciplinaVariationes
import ars_disciplina.commune.registra.RegistraGeneraDisciplinae
import ars_disciplina.commune.registra.RegistraGeneraInstrumenti
import ars_disciplina.commune.registra.RegistraGeneraPrehensionis
import ars_disciplina.commune.registra.RegistraInstrumenti
import ars_disciplina.commune.registra.RegistraLateralis
import ars_disciplina.commune.registra.RegistraModusOneris
import ars_disciplina.commune.registra.RegistraMusculi
import ars_disciplina.commune.registra.RegistraMusculiMusculiPars
import ars_disciplina.commune.registra.RegistraMusculiPars
import ars_disciplina.commune.registra.RegistraMusculiRegio
import ars_disciplina.commune.registra.RegistraMusculiRegioMusculi
import ars_disciplina.commune.registra.RegistraPrehensiones
import ars_disciplina.commune.registra.RegistraRegulae
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
        val registra: Registra<*, T>,
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

    fun <T> renova(registra: Registra<*, T>) {

        val renovatio = renovationes
            .first { it.registra === registra } as Renovatio<T>

        renova(renovatio)
    }

    private fun <T> renova(renovatio: Renovatio<T>) {

        renovatio.registra.initializa(
            renovatio.depositum.legeOmnes()
        )

    }
}