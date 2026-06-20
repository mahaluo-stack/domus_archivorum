package ars_disciplina.nexuum

import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_GENERA_PREHENSIONIS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_GENERA_PREHENSIONIS
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.nexuum.tabula.DisciplinaGeneraPrehensionis
import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas

object DepositumDisciplinaGeneraPrehensionisDisciplinae : DepositumNexuumDisciplinae<DisciplinaGeneraPrehensionis>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_GENERA_PREHENSIONIS
    override val nomenColumnaeAlterumIdentitas = NOMEN_COLUMNAE_GENERA_PREHENSIONIS_IDENTITAS
    override fun crea(
        disciplinaeIdentitas: DisciplinaeIdentitas,
        alterumIdentitas: Int
    ) = DisciplinaGeneraPrehensionis(disciplinaeIdentitas, GeneraPrehensionisIdentitas(alterumIdentitas))
}