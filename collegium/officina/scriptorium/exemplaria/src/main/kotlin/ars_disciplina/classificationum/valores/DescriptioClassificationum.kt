package ars_disciplina.classificationum.valores

import ars_disciplina.commune.interfacia.Valorabile
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class DescriptioClassificationum(override val valor: String): Valorabile