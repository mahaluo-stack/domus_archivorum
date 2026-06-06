package ars_disciplina.disciplinarum.valores

import ars_disciplina.commune.interfacia.NumerusValorabile
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class AngulusPercentum(override val valor: Double): NumerusValorabile<Double>