package commune.contractus.petitio.nexuum

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class PetitioConfiguratioMusculiRegio (
    val musculiRegioIdentitas: MusculiRegioIdentitas,
    val musculiIdentitates: Set<MusculiIdentitas>
)