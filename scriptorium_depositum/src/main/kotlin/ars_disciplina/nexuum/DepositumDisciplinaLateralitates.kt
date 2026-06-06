package ars_disciplina.nexuum

import ars_disciplina.classificationum.valores.identitas.LateralisIdentitas
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_LATERALIS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_LATERALITATES
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.nexuum.tabula.DisciplinaLateralitates

object DepositumDisciplinaLateralitates : DepositumNexuum<DisciplinaLateralitates>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_LATERALITATES
    override val nomenColumnaeAlterumIdentitas = NOMEN_COLUMNAE_LATERALIS_IDENTITAS
    override fun crea(
        disciplinaeIdentitas: DisciplinaeIdentitas,
        alterumIdentitas: Int
    ) = DisciplinaLateralitates(disciplinaeIdentitas, LateralisIdentitas(alterumIdentitas))
}