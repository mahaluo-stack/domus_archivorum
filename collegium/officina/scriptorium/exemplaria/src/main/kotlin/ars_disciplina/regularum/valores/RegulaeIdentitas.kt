package ars_disciplina.regularum.valores

import ars_disciplina.commune.interfacia.NumerusValorabile
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class RegulaeIdentitas(override val valor: Int): NumerusValorabile<Int>