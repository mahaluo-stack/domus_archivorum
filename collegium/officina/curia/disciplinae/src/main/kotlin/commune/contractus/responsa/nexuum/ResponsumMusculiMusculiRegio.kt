package commune.contractus.responsa.nexuum

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas

data class ResponsumMusculiMusculiRegio(
    val musculiIdentitas: MusculiIdentitas,
    val musculiRegioIdentitas: MusculiRegioIdentitas
)