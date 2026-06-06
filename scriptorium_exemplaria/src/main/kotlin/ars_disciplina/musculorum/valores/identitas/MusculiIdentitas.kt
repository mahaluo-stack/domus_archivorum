package ars_disciplina.musculorum.valores.identitas

import ars_disciplina.commune.interfacia.NumerusValorabile
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class MusculiIdentitas(override val valor: Int): NumerusValorabile<Int>