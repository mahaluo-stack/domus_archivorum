package ars_disciplina

import ars_disciplina.classificationum.DepositumGeneraDisciplinae
import ars_disciplina.commune.registra.*
import ars_disciplina.disciplinarum.DepositumArchetypi
import ars_disciplina.musculorum.DepositumMusculi
import ars_disciplina.musculorum.DepositumMusculiPars
import ars_disciplina.musculorum.DepositumMusculiRegio
import ars_disciplina.nexuum.*
import ars_disciplina.regularum.DepositumRegulae
import org.example.commune.registrum.RegistraAngulus
import org.example.commune.registrum.RegistraDisciplinae
import org.example.commune.registrum.RegistraMotus
import org.example.commune.registrum.RegistraVariationes
import org.example.disciplinarum.depositum.*
import org.example.instrumentorum.depositum.DepositumGeneraInstrumenti
import org.example.instrumentorum.depositum.DepositumInstrumenta


//TOOD: rename to nexus
// rename entire project to nexus
object Registra {

    // rename function to initaliza registrum
    fun initializa() {

        // classificationum
        RegistraGeneraDisciplinae.initializa(DepositumGeneraDisciplinae.legeOmnes())
        RegistraLateralis.initializa(DepositumLateralis.legeOmnes())
        RegistraModusOneris.initializa(DepositumModusOneris.legeOmnes())

        // disciplinarum
        RegistraAngulus.initializa(DepositumAngulus.legeOmnes())
        RegistraArchetypi.initializa(DepositumArchetypi.legeOmnes())
        RegistraDisciplinae.initializa(DepositumDisciplinae.legeOmnes())
        RegistraVariationes.initializa(DepositumVariationes.legeOmnes())
        RegistraMotus.initializa(DepositumMotus.legeOmnes())

        // instrumentorum
        RegistraGeneraInstrumenti.initializa(DepositumGeneraInstrumenti.legeOmnes())
        RegistraInstrumenti.initializa(DepositumInstrumenta.legeOmnes())

        // musculorum
        RegistraMusculi.initializa(DepositumMusculi.legeOmnes())
        RegistraMusculiPars.initializa(DepositumMusculiPars.legeOmnes())
        RegistraMusculiRegio.initializa(DepositumMusculiRegio.legeOmnes())

        // nexuum
        RegistraDisciplinaAnguli.initializa(DepositumDisciplinaAnguliDisciplinae.legeOmnes())
        RegistraDisciplinaArchetypi.initializa(DepositumDisciplinaArchetypiDisciplinae.legeOmnes())
        RegistraDisciplinaGeneraDisciplinae.initializa(DepositumDisciplinaGeneraDisciplinaeDisciplinae.legeOmnes())
        RegistraDisciplinaGeneraInstrumenti.initializa(DepositumDisciplinaGeneraInstrumentiDisciplinae.legeOmnes())
        RegistraDisciplinaGeneraPrehensionis.initializa(DepositumDisciplinaGeneraPrehensionisDisciplinae.legeOmnes())
        RegistraDisciplinaInstrumenti.initializa(DepositumDisciplinaInstrumentiDisciplinae.legeOmnes())
        RegistraDisciplinaLateralitates.initializa(DepositumDisciplinaLateralitatesDisciplinae.legeOmnes())
        RegistraDisciplinaModiOneris.initializa(DepositumDisciplinaModiOnerisDisciplinae.legeOmnes())
        RegistraDisciplinaMotus.initializa(DepositumDisciplinaMotusDisciplinae.legeOmnes())
        RegistraDisciplinaMusculiPars.initializa(DepositumDisciplinaMusculiParsDisciplinae.legeOmnes())
        RegistraDisciplinaPrehensiones.initializa(DepositumDisciplinaPrehensionesDisciplinae.legeOmnes())
        RegistraDisciplinaRegulae.initializa(DepositumDisciplinaRegulaeDisciplinae.legeOmnes())
        RegistraDisciplinaVariationes.initializa(DepositumDisciplinaVariationesDisciplinae.legeOmnes())
        RegistraMusculiParsMusculi.initializa(DepositumMusculiParsMusculi.legeOmnes())
        RegistraMusculiMusculiRegio.initializa(DepositumMusculiMusculiRegio.legeOmnes())

        // prehensionum
        RegistraPrehensiones.initializa(DepositumPrehensiones.legeOmnes())
        RegistraGeneraPrehensionis.initializa(DepositumGeneraPrehensionis.legeOmnes())

        // regularum
        RegistraRegulae.initializa(DepositumRegulae.legeOmnes())
    }
}