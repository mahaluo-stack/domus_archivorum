package commune.contractus.responsa.nexuum

import ars_disciplina.classificationum.valores.identitas.GeneraDisciplinaeIdentitas
import ars_disciplina.classificationum.valores.identitas.LateralisIdentitas
import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas
import ars_disciplina.disciplinarum.valores.identitas.AngulusIdentitas
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import ars_disciplina.disciplinarum.valores.identitas.VariationesIdentitas
import ars_disciplina.instrumentorum.valores.identitas.InstrumentaIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas
import ars_disciplina.prehensionum.valores.identitas.PrehensionesIdentitas
import ars_disciplina.regularum.valores.RegulaeIdentitas
import kotlinx.serialization.Serializable

@Serializable
data class ResponsumNexusDisciplinae (
    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val angulusIdentitas: AngulusIdentitas,
    val generaDisciplinaeIdentitas: GeneraDisciplinaeIdentitas,
    val generaInstrumentaIdentitas: InstrumentaIdentitas,
    val generaPrehensionisIdentitas: GeneraPrehensionisIdentitas,
    val instrumentaIdentitas: InstrumentaIdentitas,
    val lateralisIdentitas: LateralisIdentitas,
    val modusOnerisIdentitas: ModusOnerisIdentitas,
    val motusIdentitas: MotusIdentitas,
    val musculiIdentitas: MusculiIdentitas,
    val musculiParsIdentitas: MusculiParsIdentitas,
    val musculiRegioIdentitas: MusculiRegioIdentitas,
    val prehensionesIdentitas: PrehensionesIdentitas,
    val regulaeIdentitas: RegulaeIdentitas,
    val variationesIdentitas: VariationesIdentitas
)
