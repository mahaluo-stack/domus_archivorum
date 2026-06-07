package commune.contractus.responsa.instrumentorum

import ars_disciplina.instrumentorum.valores.NomenGenusInstrumenti
import ars_disciplina.instrumentorum.valores.identitas.GenusInstrumentiIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumGenusInstrumenti(
    val identitas: GenusInstrumentiIdentitas,
    val nomen: NomenGenusInstrumenti
)