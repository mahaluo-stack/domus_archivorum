package commune.contractus.responsa.nexuum

import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculiRegio
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumMusculiParsMusculi(
    val musculiParsIdentitas: MusculiParsIdentitas,
    val musculiIdentitas: MusculiIdentitas
)