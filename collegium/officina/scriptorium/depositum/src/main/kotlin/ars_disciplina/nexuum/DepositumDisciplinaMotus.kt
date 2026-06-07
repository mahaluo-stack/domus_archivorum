package ars_disciplina.nexuum

import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MOTUS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_MOTUS
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import ars_disciplina.nexuum.tabula.DisciplinaMotus

object DepositumDisciplinaMotus : DepositumNexuum<DisciplinaMotus>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_MOTUS
    override val nomenColumnaeAlterumIdentitas = NOMEN_COLUMNAE_MOTUS_IDENTITAS
    override fun crea(
        disciplinaeIdentitas: DisciplinaeIdentitas,
        alterumIdentitas: Int
    ) = DisciplinaMotus(disciplinaeIdentitas, MotusIdentitas(alterumIdentitas))
}