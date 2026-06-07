package ars_disciplina.instrumentorum.valores

import ars_disciplina.commune.interfacia.Valorabile
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class NomenGenusInstrumenti(override val valor: String): Valorabile