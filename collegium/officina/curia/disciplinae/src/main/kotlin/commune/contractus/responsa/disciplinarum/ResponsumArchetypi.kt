package commune.contractus.responsa.disciplinarum

import ars_disciplina.disciplinarum.valores.DescriptioArchetypi
import ars_disciplina.disciplinarum.valores.NomenArchetypi
import ars_disciplina.disciplinarum.valores.identitas.ArchetypusIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumArchetypi(
    val identitas: ArchetypusIdentitas,
    val nomen: NomenArchetypi,
    val descriptio: DescriptioArchetypi
)