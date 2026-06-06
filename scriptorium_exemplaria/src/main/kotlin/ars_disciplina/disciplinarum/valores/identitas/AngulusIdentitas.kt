package ars_disciplina.disciplinarum.valores.identitas

import ars_disciplina.commune.interfacia.NumerusValorabile
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class AngulusIdentitas(override val valor: Int): NumerusValorabile<Int>