package ars_disciplina.instrumentorum.valores.identitas

import ars_disciplina.commune.interfacia.NumerusValorabile
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class InstrumentaIdentitas(override val valor: Int): NumerusValorabile<Int>