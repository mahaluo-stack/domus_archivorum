package commune.contractus.petitio.musculorum

import kotlinx.serialization.Serializable

@Serializable
data class PetitioMusculiRegio(
    val identitas: Int,
    val nomen: String,
    val descriptio: String
)
