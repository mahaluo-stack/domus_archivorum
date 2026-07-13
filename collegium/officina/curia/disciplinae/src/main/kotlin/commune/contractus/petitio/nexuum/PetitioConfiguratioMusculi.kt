package commune.contractus.petitio.nexuum

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class PetitioConfiguratioMusculi (
    val musculiIdentitas: MusculiIdentitas,
    val musculiParsIdentitates: Set<MusculiParsIdentitas>
)