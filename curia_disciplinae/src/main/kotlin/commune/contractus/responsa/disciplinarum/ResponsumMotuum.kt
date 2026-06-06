package commune.contractus.responsa.disciplinarum

import ars_disciplina.disciplinarum.valores.DescriptioMotus
import ars_disciplina.disciplinarum.valores.NomenMotus
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumMotuum(
    val identitas: MotusIdentitas,
    val nomen: NomenMotus,
    val descriptio: DescriptioMotus
)