package ars_disciplina.disciplinarum.valores

import ars_disciplina.commune.interfacia.Valorabile
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class NomenArchetypi(override val valor: String): Valorabile