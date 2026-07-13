package commune.contractus.responsa

import kotlinx.serialization.Serializable
import org.apache.poi.ss.formula.functions.T

@Serializable
data class Responsum<T> (
    val feliciter: Boolean,
    val nuntius: String,
    val data: T? = null
)