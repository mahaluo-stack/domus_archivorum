package commune.contractus.responsa

import ars_disciplina.classificationum.valores.NomenGeneraDisciplinae
import ars_disciplina.classificationum.valores.NomenLateralis
import ars_disciplina.classificationum.valores.NomenModusOneris
import ars_disciplina.disciplinarum.valores.AngulusPercentum
import ars_disciplina.disciplinarum.valores.NomenDisciplinae
import ars_disciplina.disciplinarum.valores.NomenMotus
import ars_disciplina.disciplinarum.valores.NomenVariatones
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.instrumentorum.valores.NomenGenusInstrumenti
import ars_disciplina.instrumentorum.valores.NomenInstrumenti
import ars_disciplina.musculorum.valores.NomenMusculi
import ars_disciplina.musculorum.valores.NomenMusculiPars
import ars_disciplina.musculorum.valores.NomenMusculiRegio
import ars_disciplina.prehensionum.valores.NomenGeneraPrehensionis
import ars_disciplina.prehensionum.valores.NomenPrehensionis
import kotlinx.serialization.Serializable

@Serializable
data class EntiaDisciplinaResponsum(

    val disciplinaeIdentitas: DisciplinaeIdentitas,
    val disciplinae: NomenDisciplinae,

    val generaDisciplinae: NomenGeneraDisciplinae,
    val motus: NomenMotus,

    val modusOneris: Set<NomenModusOneris>,
    val lateralis: Set<NomenLateralis>,
    val variationes: Set<NomenVariatones>,

    val angulus: Set<AngulusPercentum>,
    val prehensiones: Set<NomenPrehensionis>,
    val generaPrehensiones: Set<NomenGeneraPrehensionis>,

    val musculiRegio: Set<NomenMusculiRegio>,
    val musculi: Set<NomenMusculi>,
    val musculiPars: Set<NomenMusculiPars>,

    val instrumenta: Set<NomenInstrumenti>,
    val genusInstrumenti: Set<NomenGenusInstrumenti>
)