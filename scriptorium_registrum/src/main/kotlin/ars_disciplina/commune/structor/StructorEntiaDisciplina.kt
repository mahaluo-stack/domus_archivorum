package org.example.disciplinarum.structor

import ars_disciplina.classificationum.tabula.GeneraDisciplinae
import ars_disciplina.classificationum.tabula.Lateralis
import ars_disciplina.classificationum.tabula.ModusOneris
import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import ars_disciplina.disciplinarum.tabula.Angulus
import ars_disciplina.disciplinarum.tabula.Disciplinae
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.tabula.Variationes
import ars_disciplina.instrumentorum.tabula.GenusInstrumenti
import ars_disciplina.instrumentorum.tabula.Instrumenta
import ars_disciplina.prehensionum.tabula.GeneraPrehensionis
import ars_disciplina.prehensionum.tabula.Prehensiones
import org.example.commune.exceptio.structoris.ExceptioStructorisDisciplinae
import org.example.exemplaria.tabulae.Musculi
import org.example.exemplaria.tabulae.MusculiPars
import org.example.exemplaria.tabulae.MusculiRegio

class StructorEntiaDisciplina {
    private lateinit var disciplinae: Disciplinae
    private lateinit var generaDisciplinae: GeneraDisciplinae
    private lateinit var motus: Motus
    private lateinit var modusOneris: Set<ModusOneris>
    private lateinit var lateralis: Set<Lateralis>
    private lateinit var variationes: Set<Variationes>
    private lateinit var angulus: Set<Angulus>
    private lateinit var prehensiones: Set<Prehensiones>
    private lateinit var generaPrehensiones: Set<GeneraPrehensionis>
    private lateinit var musculiRegio: Set<MusculiRegio>
    private lateinit var musculi: Set<Musculi>
    private lateinit var musculiPars: Set<MusculiPars>
    private lateinit var instrumenta: Set<Instrumenta>
    private lateinit var genusInstrumenti: Set<GenusInstrumenti>

    fun structDisciplinae(disciplinae: Disciplinae) = apply { this.disciplinae = disciplinae }
    fun structGeneraDisciplinae(generaDisciplinae: GeneraDisciplinae) =
        apply { this.generaDisciplinae = generaDisciplinae }

    fun structMotus(motus: Motus) = apply { this.motus = motus }
    fun structModusOneris(modusOneris: Set<ModusOneris>) = apply { this.modusOneris = modusOneris }
    fun structLateralis(lateralis: Set<Lateralis>) = apply { this.lateralis = lateralis }

    fun structVariationes(variationes: Set<Variationes>) = apply { this.variationes = variationes }
    fun structAngulus(angulus: Set<Angulus>) = apply { this.angulus = angulus }
    fun structPrehensiones(prehensiones: Set<Prehensiones>) = apply { this.prehensiones = prehensiones }
    fun structGeneraPrehensiones(generaPrehensiones: Set<GeneraPrehensionis>) =
        apply { this.generaPrehensiones = generaPrehensiones }

    fun structMusculiRegio(musculiRegio: Set<MusculiRegio>) = apply { this.musculiRegio = musculiRegio }
    fun structMusculi(musculi: Set<Musculi>) = apply { this.musculi = musculi }
    fun structMusculiPars(musculiPars: Set<MusculiPars>) = apply { this.musculiPars = musculiPars }

    fun structInstrumenta(instrumenta: Set<Instrumenta>) = apply { this.instrumenta = instrumenta }
    fun structGenusInstrumenti(genusInstrumenti: Set<GenusInstrumenti>) = apply { this.genusInstrumenti = genusInstrumenti }

    fun struct(): EntiaDisciplina {

        if (!::disciplinae.isInitialized)
            throw ExceptioStructorisDisciplinae("Disciplinae necessaria est.")
        if (!::generaDisciplinae.isInitialized)
            throw ExceptioStructorisDisciplinae("Genus disciplinae necessarium est.")
        if (!::motus.isInitialized)

            throw ExceptioStructorisDisciplinae("Motus necessarius est.")
        if (!::modusOneris.isInitialized || modusOneris.isEmpty())
            throw ExceptioStructorisDisciplinae("Modus oneris necessarius est.")
        if (!::lateralis.isInitialized || lateralis.isEmpty())
            throw ExceptioStructorisDisciplinae("Lateralis disciplinae necessaria est.")
        if (!::variationes.isInitialized) variationes = emptySet()
        if (!::angulus.isInitialized) angulus = emptySet()

        if (!::prehensiones.isInitialized) prehensiones = emptySet()
        if (!::generaPrehensiones.isInitialized) generaPrehensiones = emptySet()

        if(!::musculiRegio.isInitialized)
            throw ExceptioStructorisDisciplinae("Musculi regio necessaria est.")
        if(!::musculi.isInitialized)
            throw ExceptioStructorisDisciplinae("Musculi necessaria est.")
        if(!::musculiPars.isInitialized)
            throw ExceptioStructorisDisciplinae("Musculi pars necessaria est.")

        if(!::instrumenta.isInitialized)
            throw ExceptioStructorisDisciplinae("Instrumenta necessaria est.")
        if(!::genusInstrumenti.isInitialized)
            throw ExceptioStructorisDisciplinae("GenusInstrumenti pars necessaria est.")

        return EntiaDisciplina(
            disciplinae,
            generaDisciplinae,
            motus,
            modusOneris,
            lateralis,
            variationes,
            angulus,
            prehensiones,
            generaPrehensiones,
            musculiRegio,
            musculi,
            musculiPars,
            instrumenta,
            genusInstrumenti
        )
    }
}