package ars_disciplina.musculorum.valores

import ars_disciplina.commune.interfacia.Valorabile
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class NomenMusculiRegio(override val valor: String): Valorabile