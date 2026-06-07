package commune.contractus.responsa.musculorum

import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculi
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumMusculi(
    val musculiIdentitas: MusculiIdentitas,
    val musculiRegioIdentitas: MusculiRegioIdentitas,
    val nomen: NomenMusculi,
    val descriptio: DescriptioMusculi
)