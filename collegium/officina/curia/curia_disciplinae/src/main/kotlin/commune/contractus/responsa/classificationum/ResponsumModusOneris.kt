package commune.contractus.responsa.classificationum

import ars_disciplina.classificationum.valores.NomenModusOneris
import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumModusOneris(
    val identitas: ModusOnerisIdentitas,
    val nomen: NomenModusOneris
)