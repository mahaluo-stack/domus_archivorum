package commune.contractus.responsa.prehensionum

import ars_disciplina.prehensionum.valores.DescriptioPrehensionis
import ars_disciplina.prehensionum.valores.NomenGeneraPrehensionis
import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumGenusPrehensionis (
    val identitas: GeneraPrehensionisIdentitas,
    val nomen: NomenGeneraPrehensionis,
    val descriptio: DescriptioPrehensionis
)