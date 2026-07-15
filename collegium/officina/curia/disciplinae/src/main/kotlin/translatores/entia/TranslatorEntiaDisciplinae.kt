package translatores.entia

import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import commune.contractus.responsa.entia.ResponsumEntiaDisciplina

object TranslatorEntiaDisciplinae {

    fun adResponsum(
        entia: EntiaDisciplina
    ): ResponsumEntiaDisciplina {
        return ResponsumEntiaDisciplina(
            disciplinaeIdentitas = entia.disciplinae.disciplinaeIdentitas,
            disciplinae = entia.disciplinae.nomen,

            generaDisciplinae = entia.generaDisciplinae.nomen,
            motus = entia.motus.nomen,

            modusOneris = entia.modusOneris.map { it.nomen }.toSet(),
            lateralis = entia.lateralis.map { it.nomen }.toSet(),
            variationes = entia.variationes.map { it.nomen }.toSet(),

            angulus = entia.angulus.map { it.angulus }.toSet(),
            prehensiones = entia.prehensiones.map { it.nomen }.toSet(),
            generaPrehensiones = entia.generaPrehensiones.map { it.nomen }.toSet(),

            musculiRegio = entia.musculiRegio.map { it.nomen }.toSet(),
            musculi = entia.musculi.map { it.nomen }.toSet(),
            musculiPars = entia.musculiPars.map { it.nomen }.toSet(),

            instrumenta = entia.instrumenta.map { it.nomen }.toSet(),
            genusInstrumenti = entia.genusInstrumenti.map { it.nomen }.toSet()
        )
    }
}