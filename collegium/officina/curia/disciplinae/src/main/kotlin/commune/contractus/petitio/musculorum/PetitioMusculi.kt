package commune.contractus.petitio.musculorum

import kotlinx.serialization.Serializable

@Serializable
data class PetitioMusculi(
    val identitas: Int,
    val nomen: String,
    val descriptio: String
)