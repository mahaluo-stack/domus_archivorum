package commune.contractus.responsa.nexuum

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumMusculiRegioMusculi(
    val musculiRegioIdentitas: MusculiRegioIdentitas,
    val musculiIdentitates: Set<MusculiIdentitas>
)