package commune.contractus.responsa.entia

import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculi
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumEntiaMusculi (
    val musculiIdentitas: MusculiIdentitas,
    val nomenMusculi: NomenMusculi,
    val descriptioMusculi: DescriptioMusculi,
    val musculiRegioIdentitas: MusculiRegioIdentitas?,
    val musculiParsIdentitates: Set<MusculiParsIdentitas> = emptySet()
)