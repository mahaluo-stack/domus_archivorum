package commune.contractus.responsa.classificationum

import ars_disciplina.classificationum.valores.DescriptioClassificationum
import ars_disciplina.classificationum.valores.NomenGeneraDisciplinae
import ars_disciplina.classificationum.valores.NomenLateralis
import ars_disciplina.classificationum.valores.identitas.GeneraDisciplinaeIdentitas
import ars_disciplina.classificationum.valores.identitas.LateralisIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumLateralis(
    val identitas: LateralisIdentitas,
    val nomen: NomenLateralis
)