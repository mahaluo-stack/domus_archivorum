package commune.contractus.responsa.disciplinarum

import ars_disciplina.disciplinarum.valores.AngulusPercentum
import ars_disciplina.disciplinarum.valores.identitas.AngulusIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumAnguli(
    val identitas: AngulusIdentitas,
    val anguli: AngulusPercentum
)