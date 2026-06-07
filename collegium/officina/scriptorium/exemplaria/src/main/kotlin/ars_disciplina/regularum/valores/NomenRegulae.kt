package ars_disciplina.regularum.valores

import ars_disciplina.commune.interfacia.Valorabile
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class NomenRegulae(override val valor: String): Valorabile