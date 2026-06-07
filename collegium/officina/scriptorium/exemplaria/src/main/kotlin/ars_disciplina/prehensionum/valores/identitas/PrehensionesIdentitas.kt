package ars_disciplina.prehensionum.valores.identitas

import ars_disciplina.commune.interfacia.NumerusValorabile
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class PrehensionesIdentitas(override val valor: Int): NumerusValorabile<Int>