package commune.contractus.responsa.nexuum

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumMusculiMusculiPars(
    val musculiIdentitas: MusculiIdentitas,
    val musculiParsIdentitates: Set<MusculiParsIdentitas>
)