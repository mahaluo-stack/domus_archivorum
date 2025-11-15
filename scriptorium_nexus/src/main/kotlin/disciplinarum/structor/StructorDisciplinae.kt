package org.example.disciplinarum.structor

import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import ars_disciplina.disciplinarum.tabula.*
import org.example.commune.exceptio.structoris.ExceptioStructorisDisciplinae

class StructorDisciplinae {
    private var disciplinae: Disciplinae? = null
    private var generaDisciplinae: List<GeneraDisciplinae>? = null
    private var angulus: List<Angulus>? = null
    private var variationis: List<DisciplinaVariationes>? = null
    private var prehensiones: List<Prehensiones>? = null
    private var generaPrehensiones: List<GeneraPrehensionis>? = null
    private var motus: List<Motus>? = null

    fun disciplinae(disciplinae: Disciplinae) = apply { this.disciplinae = disciplinae }
    fun generaDisciplinae(generaDisciplinae: List<GeneraDisciplinae>) = apply { this.generaDisciplinae = generaDisciplinae }
    fun angulus(angulus: List<Angulus>?) = apply { this.angulus = angulus }
    fun variationis(variationis: List<DisciplinaVariationes>) = apply { this.variationis = variationis }
    fun prehensiones(prehensiones: List<Prehensiones>) = apply { this.prehensiones = prehensiones }
    fun generaPrehensiones(generaPrehensiones: List<GeneraPrehensionis>) = apply { this.generaPrehensiones = generaPrehensiones }
    fun motus(motus: List<Motus>) = apply { this.motus = motus }

    fun build(): EntiaDisciplina {
        return EntiaDisciplina(
            disciplinae ?: throw ExceptioStructorisDisciplinae("Disciplinae necessarium est."),
            generaDisciplinae ?: throw ExceptioStructorisDisciplinae("Genera disciplinae necessarium est."),
            angulus,
            variationis ?: throw ExceptioStructorisDisciplinae("Disciplina variationis necessarium est."),
            prehensiones ?: throw ExceptioStructorisDisciplinae("Prehensiones necessarium est."),
            generaPrehensiones ?: throw ExceptioStructorisDisciplinae("Genus prehensiones necessarium est."),
            motus ?: throw ExceptioStructorisDisciplinae("Motus necessarium est."),
        )
    }
}