package ars_disciplina

import ars_disciplina.commune.registrum.*
import ars_disciplina.disciplinarum.archetypus.PulldownArchetypus
import ars_disciplina.disciplinarum.regulae.RegistratorRegularumArchetyporum
import ars_disciplina.disciplinarum.regulae.RegulaGeneralis
import org.example.commune.registrum.RegistraAngulus
import org.example.commune.registrum.RegistraDisciplinae
import org.example.commune.registrum.RegistraMotus
import org.example.commune.registrum.RegistraVariationes
import org.example.commune.regulae.RegulaTribunal
import org.example.disciplinarum.depositum.*
import org.example.disciplinarum.familia.DeadliftArchetypus
import org.example.disciplinarum.familia.LungeArchetypus
import org.example.disciplinarum.familia.SquatArchetypus

object Nexus {
    val tribunal = RegulaTribunal()

    fun initializa() {

        initializaRegistra()
        initializaArchetyporum()
        registraRegulas()
    }

    private fun initializaRegistra() {
        RegistraDisciplinae.initializa(DepositumDisciplinae.legeOmnes())
        RegistraGeneraDisciplinae.initializa(DepositumGeneraDisciplinae.legeOmnes())
        RegistraMotus.initializa(DepositumMotus.legeOmnes())
        RegistraModusOneris.initializa(DepositumModusOneris.legeOmnes())
        RegistraLateralis.initializa(DepositumLateralis.legeOmnes())
        RegistraVariationes.initializa(DepositumVariationes.legeOmnes())
        RegistraAngulus.initializa(DepositumAngulus.legeOmnes())
        RegistraPrehensiones.initializa(DepositumPrehensiones.legeOmnes())
        RegistraGeneraPrehensionis.initializa(DepositumGeneraPrehensionis.legeOmnes())
    }

    private fun initializaArchetyporum() {
        RegistraArchetyporum.initializa(
            setOf(
                DeadliftArchetypus,
                SquatArchetypus,
                LungeArchetypus,
                PulldownArchetypus
            )
        )
    }

    private fun registraRegulas() {

        RegulaGeneralis.registra(tribunal)

        RegistraArchetyporum.omnia().forEach {
            RegistratorRegularumArchetyporum.registra(
                tribunal,
                it
            )
        }
    }
}