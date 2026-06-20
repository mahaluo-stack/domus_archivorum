package ars_disciplina.nexuum

import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_ANGULUS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_ANGULI
import ars_disciplina.disciplinarum.valores.identitas.AngulusIdentitas
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.nexuum.tabula.DisciplinaAnguli

object DepositumDisciplinaAnguliDisciplinae : DepositumNexuumDisciplinae<DisciplinaAnguli>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_ANGULI
    override val nomenColumnaeAlterumIdentitas = NOMEN_COLUMNAE_ANGULUS_IDENTITAS
    override fun crea(
        disciplinaeIdentitas: DisciplinaeIdentitas,
        alterumIdentitas: Int
    ) = DisciplinaAnguli(disciplinaeIdentitas, AngulusIdentitas(alterumIdentitas))
}