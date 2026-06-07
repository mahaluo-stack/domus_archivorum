package ars_disciplina.classificationum.valores.identitas

import ars_disciplina.commune.interfacia.NumerusValorabile
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class LateralisIdentitas(override val valor: Int): NumerusValorabile<Int>