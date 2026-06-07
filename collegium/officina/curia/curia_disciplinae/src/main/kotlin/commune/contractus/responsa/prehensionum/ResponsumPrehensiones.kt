package commune.contractus.responsa.prehensionum

import ars_disciplina.prehensionum.valores.DescriptioPrehensionis
import ars_disciplina.prehensionum.valores.NomenPrehensionis
import ars_disciplina.prehensionum.valores.identitas.PrehensionesIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumPrehensiones (
    val identitas: PrehensionesIdentitas,
    val nomen: NomenPrehensionis,
    val descriptio: DescriptioPrehensionis
)