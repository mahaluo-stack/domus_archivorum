package ars_disciplina.disciplinarum.valores

import ars_disciplina.commune.interfacia.Valorabile
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class DescriptioArchetypi(override val valor: String): Valorabile