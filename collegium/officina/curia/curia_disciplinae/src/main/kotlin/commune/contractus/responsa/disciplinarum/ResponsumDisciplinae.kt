package commune.contractus.responsa.disciplinarum

import ars_disciplina.disciplinarum.valores.DescriptioDisciplinae
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumDisciplinae(
    val identitas: DisciplinaeIdentitas,
    val nomen: NomenDisciplinae,
    val descriptio: DescriptioDisciplinae
)