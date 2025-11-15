package org.example.init

import org.example.commune.registrum.RegistraAngulus
import org.example.commune.registrum.RegistraDisciplinae
import org.example.commune.registrum.RegistraMotus
import org.example.disciplinarum.depositum.DepositumAngulus
import org.example.disciplinarum.depositum.DepositumDisciplinae
import org.example.disciplinarum.depositum.DepositumMotus
import org.example.disciplinarum.regulae.RegulaDeadlift
import org.example.disciplinarum.regulae.RegulaTribunal

object InitNexus {
    val tribunal = RegulaTribunal()

    fun initializa() {

        // 1. LOAD STATIC TABLES INTO REGISTRIES
        RegistraMotus.initializa(DepositumMotus.legeOmnes())
        RegistraAngulus.initializa(DepositumAngulus.legeOmnes())
        RegistraDisciplinae.initializa(DepositumDisciplinae.legeOmnes())

        // 2. REGISTER RULES (one line per exercise type)
        RegulaDeadlift.registra(tribunal)
        // ... dozens more

        // 3. READY FOR APPLICATION LOGIC
    }
}