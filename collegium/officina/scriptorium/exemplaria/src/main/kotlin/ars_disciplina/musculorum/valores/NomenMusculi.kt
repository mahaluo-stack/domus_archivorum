package ars_disciplina.musculorum.valores

import ars_disciplina.commune.interfacia.Valorabile
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class NomenMusculi(override val valor: String): Valorabile