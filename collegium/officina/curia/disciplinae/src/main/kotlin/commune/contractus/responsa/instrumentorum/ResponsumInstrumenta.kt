package commune.contractus.responsa.instrumentorum

import ars_disciplina.instrumentorum.valores.DescriptioInstrumenti
import ars_disciplina.instrumentorum.valores.NomenInstrumenti
import ars_disciplina.instrumentorum.valores.identitas.InstrumentaIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumInstrumenta(
    val identitas: InstrumentaIdentitas,
    val nomen: NomenInstrumenti,
    val descriptio: DescriptioInstrumenti
)