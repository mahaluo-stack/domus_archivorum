package disciplinarum

import ConstantiaExaminatio.FICTUM_NOMEN_DISCIPLINAE
import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import ficta.FactoriaFictaDisciplinarum
import ficta.FactoriaFictaDisciplinarum.disciplinae
import ficta.FactoriaFictaDisciplinarum.generaDisciplinae
import ficta.FactoriaFictaDisciplinarum.generaPrehensiones
import ficta.FactoriaFictaDisciplinarum.motus
import ficta.FactoriaFictaDisciplinarum.prehensiones
import ficta.FactoriaFictaDisciplinarum.variationes
import org.example.commune.exceptio.structoris.ExceptioStructorisDisciplinae
import org.example.disciplinarum.structor.StructorDisciplinae
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.jvm.java
import kotlin.test.junit5.JUnit5Asserter.assertEquals

class StructorDisciplinaeExaminatio {

    @Test
    fun examinare_structorem_creat_disciplina_validam() {
        val entia: EntiaDisciplina = FactoriaFictaDisciplinarum.entiaDisciplinae()

        assertEquals(
            "examinare nomen disciplinae",
            entia.disciplinae.nomen,
            NomenDisciplinae(FICTUM_NOMEN_DISCIPLINAE)
        )
        assertEquals(
            "examinare motus",
            1,
            entia.motus.size
        )
        assertEquals(
            "examinare disciplinae variationes",
            1,
            entia.variationes.size
        )
        assertEquals(
            "examinare genus disciplinae",
            1,
            entia.generaDisciplinae.size
        )
    }

    @Test
    fun examinare_structorem_reicit_si_disciplinae_desunt() {
        val structor = StructorDisciplinae()
            .generaDisciplinae(generaDisciplinae())
            .variationis(variationes())
            .prehensiones(prehensiones())
            .generaPrehensiones(generaPrehensiones())
            .motus(motus())

        val e = assertThrows(ExceptioStructorisDisciplinae::class.java) {
            structor.build()
        }

        assertTrue(e.message!!.contains("Disciplinae necessarium est."))
    }

    @Test
    fun examinare_structorem_reicit_si_motus_desunt() {
        val structor = StructorDisciplinae()
            .disciplinae(disciplinae())
            .generaDisciplinae(generaDisciplinae())
            .variationis(variationes())
            .prehensiones(prehensiones())
            .generaPrehensiones(generaPrehensiones())

        val e = assertThrows(ExceptioStructorisDisciplinae::class.java) {
            structor.build()
        }

        assertTrue(e.message!!.contains("Motus necessarium est."))
    }

    @Test
    fun examinare_structorem_servat_angulum_optionalem() {
        val entia: EntiaDisciplina = FactoriaFictaDisciplinarum.entiaDisciplinae(angulus = null)

        assertNull(entia.angulus)
    }
}