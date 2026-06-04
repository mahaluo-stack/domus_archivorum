package ars_disciplina

import ars_disciplina.classificationum.DepositumGeneraDisciplinae
import ars_disciplina.commune.registrum.*
import ars_disciplina.disciplinarum.DepositumArchetypi
import ars_disciplina.regularum.DepositumRegulae
import org.example.commune.registrum.RegistraAngulus
import org.example.commune.registrum.RegistraDisciplinae
import org.example.commune.registrum.RegistraMotus
import org.example.commune.registrum.RegistraVariationes
import org.example.commune.regulae.RegulaTribunal
import org.example.disciplinarum.depositum.*

object Nexus {
    val tribunal = RegulaTribunal()

    fun initializa() {
        initializaRegistra()
    }

    private fun initializaRegistra() {
        RegistraDisciplinae.initializa(DepositumDisciplinae.legeOmnes())
        RegistraArchetypi.initializa(DepositumArchetypi.legeOmnes())
        RegistraRegulae.initializa(DepositumRegulae.legeOmnes())
        RegistraGeneraDisciplinae.initializa(DepositumGeneraDisciplinae.legeOmnes())
        RegistraMotus.initializa(DepositumMotus.legeOmnes())
        RegistraModusOneris.initializa(DepositumModusOneris.legeOmnes())
        RegistraLateralis.initializa(DepositumLateralis.legeOmnes())
        RegistraVariationes.initializa(DepositumVariationes.legeOmnes())
        RegistraAngulus.initializa(DepositumAngulus.legeOmnes())
        RegistraPrehensiones.initializa(DepositumPrehensiones.legeOmnes())
        RegistraGeneraPrehensionis.initializa(DepositumGeneraPrehensionis.legeOmnes())
    }
}