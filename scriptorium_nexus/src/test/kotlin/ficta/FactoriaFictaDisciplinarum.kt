package ficta

import ConstantiaExaminatio.FICTUM_ANGULUS_PERCENTUM
import ConstantiaExaminatio.FICTUM_NOMEN_DISCIPLINAE
import ConstantiaExaminatio.FICTUM_NOMEN_DISCIPLINA_VARIATIONES
import ConstantiaExaminatio.FICTUM_NOMEN_GENERA_DISCIPLINAE
import ConstantiaExaminatio.FICTUM_NOMEN_GENUS_PREHENSIONIS
import ConstantiaExaminatio.FICTUM_NOMEN_MOTUS
import ConstantiaExaminatio.FICTUM_NOMEN_PREHENSIONIS
import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import ars_disciplina.disciplinarum.tabula.*
import ars_disciplina.disciplinarum.valores.*
import ars_disciplina.disciplinarum.valores.identitas.*

object FactoriaFictaDisciplinarum {

    fun entiaDisciplinae(
        disciplinae: Disciplinae = disciplinae(),
        generaDisciplinae: List<GeneraDisciplinae> = generaDisciplinae(),
        angulus: List<Angulus>? = angulus(),
        variationes: List<DisciplinaVariationes> = variationes(),
        prehensiones: List<Prehensiones> = prehensiones(),
        generaPrehensiones: List<GeneraPrehensionis> = generaPrehensiones(),
        motus: List<Motus> = motus()
    ) = EntiaDisciplina(
        disciplinae,
        generaDisciplinae,
        angulus,
        variationes,
        prehensiones,
        generaPrehensiones,
        motus
    )

    fun disciplinae(): Disciplinae =
        Disciplinae(
            DisciplinaeIdentitas(1),
            NomenDisciplinae(FICTUM_NOMEN_DISCIPLINAE),
            DescriptioDisciplina("a strength training exercise that primarily involves hips, legs, glutes and back.")
        )

    fun generaDisciplinae(): List<GeneraDisciplinae> =
        listOf(
            GeneraDisciplinae(
                GeneraDisciplinaeIdentitas(1),
                NomenGeneraDisciplinae(FICTUM_NOMEN_GENERA_DISCIPLINAE),
                DescriptioDisciplina("a compound exercise is a multi-joint movement that simultaneously works multiple muscle groups.")
            )
        )

    fun variationes(): List<DisciplinaVariationes> =
        listOf(
            DisciplinaVariationes(
                DisciplinaVariationesIdentitas(1),
                NomenDisciplinaVariatones(FICTUM_NOMEN_DISCIPLINA_VARIATIONES)
            )
        )

    fun prehensiones(): List<Prehensiones> =
        listOf(
            Prehensiones(
                PrehensionesIdentitas(1),
                NomenPrehensionis(FICTUM_NOMEN_PREHENSIONIS),
                DescriptioPrehensionis("a neutral grip width is about as wide as your shoulder width.")
            )
        )

    fun generaPrehensiones(): List<GeneraPrehensionis> =
        listOf(
            GeneraPrehensionis(
                GeneraPrehensionisIdentitas(1),
                NomenGeneraPrehensionis(FICTUM_NOMEN_GENUS_PREHENSIONIS),
                DescriptioPrehensionis("with a pronated grip, also called overhand grip, both palms are facing down or away from you.")
            )
        )

    fun motus(): List<Motus> =
        listOf(
            Motus(
                MotusIdentitas(1),
                NomenMotus(FICTUM_NOMEN_MOTUS)
            )
        )

    fun angulus(): List<Angulus> =
        listOf(
            Angulus(
                AngulusIdentitas(1),
                AngulusPercentum(FICTUM_ANGULUS_PERCENTUM)
            )
        )
}