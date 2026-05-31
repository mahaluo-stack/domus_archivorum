package ars_disciplina.initializa

import org.example.commune.registrum.*
import org.example.commune.regulae.RegulaTribunal
import org.example.disciplinarum.depositum.*
import org.example.disciplinarum.regulae.disciplinae.RegulaDeadlift
import org.example.disciplinarum.regulae.disciplinae.RegulaGeneralis
import org.example.disciplinarum.regulae.disciplinae.RegulaLunge
import org.example.disciplinarum.regulae.disciplinae.RegulaSquat

object Nexuum {
    val tribunal = RegulaTribunal()

    fun initializa() {

        RegistraDisciplinae.initializa(DepositumDisciplinae.legeOmnes())
        RegistraGeneraDisciplinae.initializa(DepositumGeneraDisciplinae.legeOmnes())
        RegistraMotus.initializa(DepositumMotus.legeOmnes())
        RegistraModusOneris.initializa(DepositumModusOneris.legeOmnes())
        RegistraLateralis.initializa(DepositumLateralis.legeOmnes())
        RegistraVariationes.initializa(DepositumVariationes.legeOmnes())
        RegistraAngulus.initializa(DepositumAngulus.legeOmnes())
        RegistraPrehensiones.initializa(DepositumPrehensiones.legeOmnes())
        RegistraGeneraPrehensionis.initializa(DepositumGeneraPrehensionis.legeOmnes())

        // 2. REGISTER RULES
        RegulaDeadlift.registra(tribunal)
        RegulaSquat.registra(tribunal)
        RegulaLunge.registra(tribunal)
        RegulaGeneralis.registra(tribunal)

        // present rules and exercises to GUI
        //




    }


}