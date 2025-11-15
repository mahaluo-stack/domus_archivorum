package org.example.disciplinarum.regulae

import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import org.example.commune.exceptio.regulae.FabricaExceptionumRegularum
import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae.CONVENTIONAL_DEADLIFT
import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae.RACK_PULL
import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae.ROMANIAN_DEADLIFT
import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae.STIFF_LEG_DEADLIFT
import org.example.commune.exemplaria.constantia.ConstantiaDisciplinae.SUMO_DEADLIFT
import org.example.commune.exemplaria.constantia.ConstantiaGeneraDisciplinae.COMPOUND
import org.example.commune.exemplaria.constantia.ConstantiaGeneraPrehensionis.HOOK
import org.example.commune.exemplaria.constantia.ConstantiaGeneraPrehensionis.MIXED
import org.example.commune.exemplaria.constantia.ConstantiaGeneraPrehensionis.PRONATED
import org.example.commune.exemplaria.constantia.ConstantiaMotus.PULL
import org.example.commune.exemplaria.constantia.ConstantiaPrehensionis.NEUTRAL
import org.example.commune.exemplaria.constantia.ConstantiaPrehensionis.WIDE
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.BANDED
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.DEFICIT
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.ECCENTRIC
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.ELEVATED
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.NEGATIVE
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.PAUSE
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.PINNED
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.STANDING
import org.example.commune.exemplaria.constantia.ConstantiaVariationum.TOUCH_AND_GO

object RegulaDeadlift {

    private val nomenVariantes = listOf(
        NomenDisciplinae(CONVENTIONAL_DEADLIFT),
        NomenDisciplinae(ROMANIAN_DEADLIFT),
        NomenDisciplinae(SUMO_DEADLIFT),
        NomenDisciplinae(STIFF_LEG_DEADLIFT),
        NomenDisciplinae(RACK_PULL)
    )

    private val variationesPermissae = setOf(
        NEGATIVE,
        TOUCH_AND_GO,
        PAUSE,
        STANDING,
        ELEVATED,
        DEFICIT,
        PINNED,
        ECCENTRIC,
        BANDED
    )

    private val generaPrehensionisPermissae = setOf(
        PRONATED,
        MIXED,
        HOOK
    )

    private val prehensionesPermissae = setOf(
        NEUTRAL,
        WIDE
    )

    fun registra(tribunal: RegulaTribunal) {

        // Rule #1 - the deadlift can not be performed with an incline or decline angle
        nomenVariantes.forEach { nomen ->
            tribunal.registra(nomen) { d ->
                if (d.angulus != null) {
                    throw FabricaExceptionumRegularum.violatio(
                        nomen.toString(),
                        "angulus non permittitur."
                    )
                }
            }
        }

        // Rule #2 - the deadlift is strictly a pulling exercise
        nomenVariantes.forEach { nomen ->
            tribunal.registra(nomen) { d ->
                val motus = d.motus.singleOrNull()
                    ?: throw FabricaExceptionumRegularum.violatio(
                        nomen.toString(),
                        "motus unicus esse debet."
                    )

                if (motus.nomen.toString().lowercase() != PULL) {
                    throw FabricaExceptionumRegularum.violatio(
                        nomen.toString(),
                        "motus debet esse $PULL."
                    )
                }
            }
        }

        // Rule #3 - the deadlift can only be performed with following variations
        nomenVariantes.forEach { nomen ->
            tribunal.registra(nomen) { d ->
                val invalid = d.variationes
                    .map { it.nomen.toString().lowercase() }
                    .filter { it !in variationesPermissae }

                if (invalid.isNotEmpty()) {
                    throw FabricaExceptionumRegularum.violatio(
                        nomen.toString(),
                        "variationes non permittuntur: ${invalid.joinToString()}"
                    )
                }
            }
        }

        // Rule #4 - the deadlift is strictly a compound exercise
        nomenVariantes.forEach { nomen ->
            tribunal.registra(nomen) { d ->
                val genusDisciplinae = d.generaDisciplinae.singleOrNull()
                    ?: throw FabricaExceptionumRegularum.violatio(
                        nomen.toString(),
                        "genus disciplinae unicus esse debet."
                    )

                if (genusDisciplinae.nomen.toString().lowercase() != COMPOUND) {
                    throw FabricaExceptionumRegularum.violatio(
                        nomen.toString(),
                        "genus disciplinae debet esse $COMPOUND."
                    )
                }
            }
        }

        // Rule #5 - the deadlift can only be performed using the following grip variations
        nomenVariantes.forEach { nomen ->
            tribunal.registra(nomen) { d ->
                val invalid = d.generaPrehensiones
                    .map { it.nomen.toString().lowercase() }
                    .filter { it !in generaPrehensionisPermissae }

                if (invalid.isNotEmpty()) {
                    throw FabricaExceptionumRegularum.violatio(
                        nomen.toString(),
                        "genus prehensionis non permittuntur: ${invalid.joinToString()}"
                    )
                }
            }
        }

        // Rule #6 - the deadlift can only be performed using the following grip widths
        nomenVariantes.forEach { nomen ->
            tribunal.registra(nomen) { d ->
                val invalid = d.prehensiones
                    .map { it.nomen.toString().lowercase() }
                    .filter { it !in prehensionesPermissae }

                if (invalid.isNotEmpty()) {
                    throw FabricaExceptionumRegularum.violatio(
                        nomen.toString(),
                        "prehensiones non permittuntur: ${invalid.joinToString()}"
                    )
                }
            }
        }
    }
}