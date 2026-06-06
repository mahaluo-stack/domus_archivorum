package ars_disciplina.nexuum

import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_REGULAE_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_REGULAE
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.nexuum.tabula.DisciplinaRegulae
import ars_disciplina.regularum.valores.RegulaeIdentitas

object DepositumDisciplinaRegulae : DepositumNexuum<DisciplinaRegulae>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_REGULAE
    override val nomenColumnaeAlterumIdentitas = NOMEN_COLUMNAE_REGULAE_IDENTITAS
    override fun crea(
        disciplinaeIdentitas: DisciplinaeIdentitas,
        alterumIdentitas: Int
    ) = DisciplinaRegulae(disciplinaeIdentitas, RegulaeIdentitas(alterumIdentitas))
}