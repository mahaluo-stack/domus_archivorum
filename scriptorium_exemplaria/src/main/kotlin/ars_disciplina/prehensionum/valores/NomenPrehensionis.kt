package ars_disciplina.prehensionum.valores

import ars_disciplina.commune.interfacia.Valorabile
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class NomenPrehensionis(override val valor: String): Valorabile