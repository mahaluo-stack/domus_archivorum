package commune.contractus.responsa.classificationum

import ars_disciplina.classificationum.valores.DescriptioClassificationum
import ars_disciplina.classificationum.valores.NomenGeneraDisciplinae
import ars_disciplina.classificationum.valores.identitas.GeneraDisciplinaeIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumGeneraDisciplinae(
    val identitas: GeneraDisciplinaeIdentitas,
    val nomen: NomenGeneraDisciplinae,
    val descriptio: DescriptioClassificationum
)