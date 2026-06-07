package commune.contractus.responsa.musculorum

import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculiRegio
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumMusculiRegio(
    val musculiRegioIdentitas: MusculiRegioIdentitas,
    val nomen: NomenMusculiRegio,
    val descriptio: DescriptioMusculi
)