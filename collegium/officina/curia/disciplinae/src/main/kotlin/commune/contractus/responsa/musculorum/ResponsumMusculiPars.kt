package commune.contractus.responsa.musculorum

import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculiPars
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumMusculiPars(
    val musculiParsIdentitas: MusculiParsIdentitas,
    val nomen: NomenMusculiPars,
    val descriptio: DescriptioMusculi
)