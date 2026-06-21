package ficta

import ConstantiaExaminatio.FICTUM_ANGULUS_PERCENTUM
import ConstantiaExaminatio.FICTUM_DESCRIPTIO
import ConstantiaExaminatio.FICTUM_MODUS_ONERIS
import ConstantiaExaminatio.FICTUM_NOMEN_DISCIPLINAE
import ConstantiaExaminatio.FICTUM_NOMEN_DISCIPLINAE_LATERALIS
import ConstantiaExaminatio.FICTUM_NOMEN_DISCIPLINA_VARIATIONES
import ConstantiaExaminatio.FICTUM_NOMEN_GENERA_DISCIPLINAE
import ConstantiaExaminatio.FICTUM_NOMEN_GENUS_INSTRUMENTI
import ConstantiaExaminatio.FICTUM_NOMEN_GENUS_PREHENSIONIS
import ConstantiaExaminatio.FICTUM_NOMEN_INSTRUMENTA
import ConstantiaExaminatio.FICTUM_NOMEN_MOTUS
import ConstantiaExaminatio.FICTUM_NOMEN_MUSCULI
import ConstantiaExaminatio.FICTUM_NOMEN_MUSCULI_PARS
import ConstantiaExaminatio.FICTUM_NOMEN_MUSCULI_REGIO
import ConstantiaExaminatio.FICTUM_NOMEN_PREHENSIONIS
import ars_disciplina.classificationum.tabula.GeneraDisciplinae
import ars_disciplina.classificationum.tabula.Lateralis
import ars_disciplina.classificationum.tabula.ModusOneris
import ars_disciplina.classificationum.valores.DescriptioClassificationum
import ars_disciplina.classificationum.valores.NomenGeneraDisciplinae
import ars_disciplina.classificationum.valores.NomenLateralis
import ars_disciplina.classificationum.valores.NomenModusOneris
import ars_disciplina.classificationum.valores.identitas.GeneraDisciplinaeIdentitas
import ars_disciplina.classificationum.valores.identitas.LateralisIdentitas
import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas
import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import ars_disciplina.disciplinarum.tabula.Angulus
import ars_disciplina.disciplinarum.tabula.Disciplinae
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.tabula.Variationes
import ars_disciplina.disciplinarum.valores.*
import ars_disciplina.disciplinarum.valores.identitas.AngulusIdentitas
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import ars_disciplina.disciplinarum.valores.identitas.VariationesIdentitas
import ars_disciplina.instrumentorum.tabula.GenusInstrumenti
import ars_disciplina.instrumentorum.tabula.Instrumenta
import ars_disciplina.instrumentorum.valores.DescriptioInstrumenti
import ars_disciplina.instrumentorum.valores.NomenGenusInstrumenti
import ars_disciplina.instrumentorum.valores.NomenInstrumenti
import ars_disciplina.instrumentorum.valores.identitas.GenusInstrumentiIdentitas
import ars_disciplina.instrumentorum.valores.identitas.InstrumentaIdentitas
import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculi
import ars_disciplina.musculorum.valores.NomenMusculiPars
import ars_disciplina.musculorum.valores.NomenMusculiRegio
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import ars_disciplina.prehensionum.tabula.GeneraPrehensionis
import ars_disciplina.prehensionum.tabula.Prehensiones
import ars_disciplina.prehensionum.valores.DescriptioPrehensionis
import ars_disciplina.prehensionum.valores.NomenGeneraPrehensionis
import ars_disciplina.prehensionum.valores.NomenPrehensionis
import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas
import ars_disciplina.prehensionum.valores.identitas.PrehensionesIdentitas
import org.example.exemplaria.tabulae.Musculi
import org.example.exemplaria.tabulae.MusculiPars
import org.example.exemplaria.tabulae.MusculiRegio

object FactoriaFictaDisciplinarum {

    fun entiaDisciplinae(
        disciplinae: Disciplinae = disciplinae(),
        generaDisciplinae: GeneraDisciplinae = generaDisciplinae(),
        motus: Motus = motus(),
        modusOneris: Set<ModusOneris> = modusOneris(),
        lateralisDisciplinae: Set<Lateralis> = lateralisDisciplinae(),
        variationes: Set<Variationes> = variationes(),
        angulus: Set<Angulus> = angulus(),
        prehensiones: Set<Prehensiones> = prehensiones(),
        generaPrehensiones: Set<GeneraPrehensionis> = generaPrehensiones(),
        musculiRegio: Set<MusculiRegio> = musculiRegio(),
        musculiPars: Set<MusculiPars> = musculiPars(),
        musculi: Set<Musculi> = musculi(),
        instrumenti: Set<Instrumenta> = instrumenti(),
        generaInstrumenti: Set<GenusInstrumenti> = generaInstrumenti()

    ) = EntiaDisciplina(
        disciplinae,
        generaDisciplinae,
        motus,
        modusOneris,
        lateralisDisciplinae,
        variationes,
        angulus,
        prehensiones,
        generaPrehensiones,
        musculiRegio,
        musculi,
        musculiPars,
        instrumenti,
        generaInstrumenti
    )

    fun disciplinae() = Disciplinae(
        DisciplinaeIdentitas(1),
        NomenDisciplinae(FICTUM_NOMEN_DISCIPLINAE),
        DescriptioDisciplinae("a strength training exercise that primarily involves hips, legs, glutes and back.")
    )

    fun generaDisciplinae() = GeneraDisciplinae(
        GeneraDisciplinaeIdentitas(1),
        NomenGeneraDisciplinae(FICTUM_NOMEN_GENERA_DISCIPLINAE),
        DescriptioClassificationum("a compound exercise is a multi-joint movement that simultaneously works multiple muscle groups.")
    )

    fun motus() = Motus(
        MotusIdentitas(1),
        NomenMotus(FICTUM_NOMEN_MOTUS),
        DescriptioMotus(FICTUM_DESCRIPTIO)
    )

    fun modusOneris() = setOf(
        ModusOneris(
            ModusOnerisIdentitas(1),
            NomenModusOneris(FICTUM_MODUS_ONERIS)
        )
    )

    fun lateralisDisciplinae() = setOf(
        Lateralis(
            LateralisIdentitas(1),
            NomenLateralis(FICTUM_NOMEN_DISCIPLINAE_LATERALIS)
        )
    )

    fun angulus() = setOf(
        Angulus(
            AngulusIdentitas(1),
            AngulusPercentum(FICTUM_ANGULUS_PERCENTUM)
        )
    )

    fun variationes() = setOf(
        Variationes(
            VariationesIdentitas(1),
            NomenVariatones(FICTUM_NOMEN_DISCIPLINA_VARIATIONES)
        )
    )

    fun prehensiones() = setOf(
        Prehensiones(
            PrehensionesIdentitas(1),
            NomenPrehensionis(FICTUM_NOMEN_PREHENSIONIS),
            DescriptioPrehensionis("a neutral grip width is about as wide as your shoulder width.")
        )
    )

    fun generaPrehensiones() = setOf(
        GeneraPrehensionis(
            GeneraPrehensionisIdentitas(1),
            NomenGeneraPrehensionis(FICTUM_NOMEN_GENUS_PREHENSIONIS),
            DescriptioPrehensionis("with a pronated grip, also called overhand grip, both palms are facing down or away from you.")
        )
    )

    fun musculi() = setOf(
        Musculi(
            MusculiIdentitas(1),
            NomenMusculi(FICTUM_NOMEN_MUSCULI),
            DescriptioMusculi(FICTUM_DESCRIPTIO)
        )
    )

    fun musculiPars() = setOf(
        MusculiPars(
            MusculiParsIdentitas(1),
            NomenMusculiPars(FICTUM_NOMEN_MUSCULI_PARS),
            DescriptioMusculi(FICTUM_DESCRIPTIO)
        )
    )

    fun musculiRegio() = setOf(
        MusculiRegio(
            MusculiRegioIdentitas(1),
            NomenMusculiRegio(FICTUM_NOMEN_MUSCULI_REGIO),
            DescriptioMusculi(FICTUM_DESCRIPTIO)
        )
    )

    fun instrumenti() = setOf(
        Instrumenta(
            InstrumentaIdentitas(1),
            NomenInstrumenti(FICTUM_NOMEN_INSTRUMENTA),
            DescriptioInstrumenti(FICTUM_DESCRIPTIO)
        )
    )

    fun generaInstrumenti() = setOf(
        GenusInstrumenti(
            GenusInstrumentiIdentitas(1),
            NomenGenusInstrumenti(FICTUM_NOMEN_GENUS_INSTRUMENTI),
        )
    )
}