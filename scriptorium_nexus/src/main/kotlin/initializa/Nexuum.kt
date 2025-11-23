package initializa

import org.example.commune.registrum.*
import org.example.disciplinarum.depositum.*
import org.example.disciplinarum.regulae.RegulaTribunal
import org.example.disciplinarum.regulae.disciplinae.RegulaDeadlift
import org.example.disciplinarum.regulae.disciplinae.RegulaLunge
import org.example.disciplinarum.regulae.disciplinae.RegulaSquat
import org.example.nexuum.familia.DeadliftFamilia

object Nexuum {
    val tribunal = RegulaTribunal()

    fun initializa() {

        // 1. LOAD REGISTRIES
        RegistraDisciplinae.initializa(DepositumDisciplinae.legeOmnes())
        RegistraGeneraDisciplinae.initializa(DepositumGeneraDisciplinae.legeOmnes())
        RegistraMotus.initializa(DepositumMotus.legeOmnes())
        RegistraModusOneris.initializa(DepositumModusOneris.legeOmnes())
        RegistraLateralisDisciplinae.initializa(DepositumLateralisDisciplinae.legeOmnes())
        RegistraDisciplinaVariationes.initializa(DepositumDisciplinaVariationes.legeOmnes())
        RegistraAngulus.initializa(DepositumAngulus.legeOmnes())
        RegistraPrehensiones.initializa(DepositumPrehensiones.legeOmnes())
        RegistraGeneraPrehensionis.initializa(DepositumGeneraPrehensionis.legeOmnes())

        // 2. REGISTER RULES
        RegulaDeadlift.registra(tribunal)
        RegulaSquat.registra(tribunal)
        RegulaLunge.registra(tribunal)

        // 3. Create entities
        val deadliftExercises = DeadliftFamilia.crea()



    }
}