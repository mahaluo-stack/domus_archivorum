package commune.contractus.responsa.regularum

import ars_disciplina.regularum.valores.DescriptioRegulae
import ars_disciplina.regularum.valores.GenusRegulae
import ars_disciplina.regularum.valores.NomenRegulae
import ars_disciplina.regularum.valores.RegulaeIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumRegulae(
    val identitas: RegulaeIdentitas,
    val nomen: NomenRegulae,
    val genusRegulae: GenusRegulae,
    val descriptio: DescriptioRegulae
)