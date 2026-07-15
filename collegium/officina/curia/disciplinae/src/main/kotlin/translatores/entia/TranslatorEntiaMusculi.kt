package translatores.entia

import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import commune.contractus.responsa.entia.ResponsumEntiaDisciplina
import commune.contractus.responsa.entia.ResponsumEntiaMusculi
import officina.actorum.exemplaria.archivum.EntiaMusculi

object TranslatorEntiaMusculi {
    fun adResponsum(
        entia: EntiaMusculi
    ): ResponsumEntiaMusculi {
        return ResponsumEntiaMusculi(
            musculiIdentitas = entia.musculiIdentitas,
            nomenMusculi = entia.nomenMusculi,
            descriptioMusculi = entia.descriptioMusculi,
            musculiRegioIdentitas = entia.musculiRegio.musculiRegioIdentitas,
            musculiParsIdentitates = entia.musculiPars.map { it.musculiParsIdentitas }.toSet()
        )
    }
}