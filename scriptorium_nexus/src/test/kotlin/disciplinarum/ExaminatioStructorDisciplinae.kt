package disciplinarum

import ConstantiaExaminatio.FICTUM_NOMEN_DISCIPLINAE
import ConstantiaExaminatio.FICTUM_NOMEN_GENERA_DISCIPLINAE
import ConstantiaExaminatio.FICTUM_NOMEN_MOTUS
import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import ficta.FactoriaFictaDisciplinarum
import ficta.FactoriaFictaDisciplinarum.angulus
import ficta.FactoriaFictaDisciplinarum.disciplinae
import ficta.FactoriaFictaDisciplinarum.generaDisciplinae
import ficta.FactoriaFictaDisciplinarum.generaPrehensiones
import ficta.FactoriaFictaDisciplinarum.lateralisDisciplinae
import ficta.FactoriaFictaDisciplinarum.modusOneris
import ficta.FactoriaFictaDisciplinarum.motus
import ficta.FactoriaFictaDisciplinarum.prehensiones
import ficta.FactoriaFictaDisciplinarum.variationes
import org.example.commune.exceptio.structoris.ExceptioStructorisDisciplinae
import org.example.disciplinarum.structor.StructorDisciplinae
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.junit5.JUnit5Asserter.assertEquals

class StructorDisciplinaeExaminatio {

    @Test
    fun examinare_structorem_creat_disciplina_validam() {
        val entia: EntiaDisciplina = FactoriaFictaDisciplinarum.entiaDisciplinae()

        assertEquals(
            "Examinare nomen disciplinae",
            FICTUM_NOMEN_DISCIPLINAE,
            entia.disciplinae.nomen.valor
        )
        assertEquals(
            "Examinare motus",
            FICTUM_NOMEN_MOTUS,
            entia.motus.nomen.valor
        )
        assertEquals(
            "Examinare disciplinae variationes",
            1,
            entia.variationes.size
        )
        assertEquals(
            "Examinare genus disciplinae",
            FICTUM_NOMEN_GENERA_DISCIPLINAE,
            entia.generaDisciplinae.nomen.valor
        )
    }

    @Test
    fun examinare_structorem_reicit_si_disciplinae_desunt() {
        val structor = StructorDisciplinae()
            .structGeneraDisciplinae(generaDisciplinae())
            .structMotus(motus())
            .structModusOneris(modusOneris())
            .structLateralisDisciplinae(lateralisDisciplinae())
            .structVariationes(variationes())
            .structAngulus(angulus())
            .structPrehensiones(prehensiones())
            .structGeneraPrehensiones(generaPrehensiones())

        val e = assertThrows(ExceptioStructorisDisciplinae::class.java) {
            structor.struct()
        }

        assertTrue(e.message!!.contains("Disciplinae necessaria"))
    }

    @Test
    fun examinare_structorem_reicit_si_motus_desunt() {
        val structor = StructorDisciplinae()
            .structDisciplinae(disciplinae())
            .structGeneraDisciplinae(generaDisciplinae())
            .structModusOneris(modusOneris())
            .structLateralisDisciplinae(lateralisDisciplinae())
            .structVariationes(variationes())
            .structAngulus(angulus())
            .structPrehensiones(prehensiones())
            .structGeneraPrehensiones(generaPrehensiones())

        val e = assertThrows(ExceptioStructorisDisciplinae::class.java) {
            structor.struct()
        }

        assertTrue(e.message!!.contains("Motus necessarius"))
    }
}