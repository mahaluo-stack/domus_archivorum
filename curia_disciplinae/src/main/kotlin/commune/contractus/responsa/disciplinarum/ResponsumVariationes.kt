package commune.contractus.responsa.disciplinarum

import ars_disciplina.disciplinarum.valores.NomenVariatones
import ars_disciplina.disciplinarum.valores.identitas.VariationesIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumVariationes(
    val identitas: VariationesIdentitas,
    val nomen: NomenVariatones
)