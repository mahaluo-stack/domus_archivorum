package ars_disciplina.regularum.valores

import ars_disciplina.commune.interfacia.Valorabile
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class DescriptioRegulae(override val valor: String): Valorabile