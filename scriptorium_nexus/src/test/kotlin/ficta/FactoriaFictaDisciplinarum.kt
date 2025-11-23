package ficta

import ConstantiaExaminatio.FICTUM_ANGULUS_PERCENTUM
import ConstantiaExaminatio.FICTUM_MODUS_ONERIS
import ConstantiaExaminatio.FICTUM_NOMEN_DISCIPLINAE
import ConstantiaExaminatio.FICTUM_NOMEN_DISCIPLINAE_LATERALIS
import ConstantiaExaminatio.FICTUM_NOMEN_DISCIPLINA_VARIATIONES
import ConstantiaExaminatio.FICTUM_NOMEN_GENERA_DISCIPLINAE
import ConstantiaExaminatio.FICTUM_NOMEN_GENUS_PREHENSIONIS
import ConstantiaExaminatio.FICTUM_NOMEN_MOTUS
import ConstantiaExaminatio.FICTUM_NOMEN_PREHENSIONIS
import ars_disciplina.classificationum.tabula.GeneraDisciplinae
import ars_disciplina.classificationum.tabula.LateralisDisciplinae
import ars_disciplina.classificationum.tabula.ModusOneris
import ars_disciplina.classificationum.valores.NomenGeneraDisciplinae
import ars_disciplina.classificationum.valores.NomenLateralisDisciplinae
import ars_disciplina.classificationum.valores.NomenModusOneris
import ars_disciplina.classificationum.valores.identitas.GeneraDisciplinaeIdentitas
import ars_disciplina.classificationum.valores.identitas.LateralisDisciplinaeIdentitas
import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas
import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import ars_disciplina.disciplinarum.tabula.Angulus
import ars_disciplina.disciplinarum.tabula.DisciplinaVariationes
import ars_disciplina.disciplinarum.tabula.Disciplinae
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.valores.*
import ars_disciplina.disciplinarum.valores.identitas.AngulusIdentitas
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaVariationesIdentitas
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import ars_disciplina.prehensionum.tabula.GeneraPrehensionis
import ars_disciplina.prehensionum.tabula.Prehensiones
import ars_disciplina.prehensionum.valores.DescriptioPrehensionis
import ars_disciplina.prehensionum.valores.NomenGeneraPrehensionis
import ars_disciplina.prehensionum.valores.NomenPrehensionis
import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas
import ars_disciplina.prehensionum.valores.identitas.PrehensionesIdentitas

object FactoriaFictaDisciplinarum {

    fun entiaDisciplinae(
        disciplinae: Disciplinae = disciplinae(),
        generaDisciplinae: GeneraDisciplinae = generaDisciplinae(),
        motus: Motus = motus(),
        modusOneris: Set<ModusOneris> = modusOneris(),
        lateralisDisciplinae: Set<LateralisDisciplinae> = lateralisDisciplinae(),
        variationes: Set<DisciplinaVariationes> = variationes(),
        angulus: Set<Angulus> = angulus(),
        prehensiones: Set<Prehensiones> = prehensiones(),
        generaPrehensiones: Set<GeneraPrehensionis> = generaPrehensiones()

    ) = EntiaDisciplina(
        disciplinae,
        generaDisciplinae,
        motus,
        modusOneris,
        lateralisDisciplinae,
        variationes,
        angulus,
        prehensiones,
        generaPrehensiones
    )

    fun disciplinae() = Disciplinae(
        DisciplinaeIdentitas(1),
        NomenDisciplinae(FICTUM_NOMEN_DISCIPLINAE),
        DescriptioDisciplina("a strength training exercise that primarily involves hips, legs, glutes and back.")
    )

    fun generaDisciplinae() = GeneraDisciplinae(
        GeneraDisciplinaeIdentitas(1),
        NomenGeneraDisciplinae(FICTUM_NOMEN_GENERA_DISCIPLINAE),
        DescriptioDisciplina("a compound exercise is a multi-joint movement that simultaneously works multiple muscle groups.")
    )

    fun motus() = Motus(
        MotusIdentitas(1),
        NomenMotus(FICTUM_NOMEN_MOTUS)
    )

    fun modusOneris() = setOf(
        ModusOneris(
            ModusOnerisIdentitas(1),
            NomenModusOneris(FICTUM_MODUS_ONERIS)
        )
    )

    fun lateralisDisciplinae() = setOf(
        LateralisDisciplinae(
            LateralisDisciplinaeIdentitas(1),
            NomenLateralisDisciplinae(FICTUM_NOMEN_DISCIPLINAE_LATERALIS)
        )
    )

    fun angulus() = setOf(
        Angulus(
            AngulusIdentitas(1),
            AngulusPercentum(FICTUM_ANGULUS_PERCENTUM)
        )
    )

    fun variationes() = setOf(
        DisciplinaVariationes(
            DisciplinaVariationesIdentitas(1),
            NomenDisciplinaVariatones(FICTUM_NOMEN_DISCIPLINA_VARIATIONES)
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
}