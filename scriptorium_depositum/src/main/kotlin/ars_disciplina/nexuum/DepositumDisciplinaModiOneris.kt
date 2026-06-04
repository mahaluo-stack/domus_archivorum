package ars_disciplina.nexuum

import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MODUS_ONERIS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_MODI_ONERIS
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.nexuum.tabula.DisciplinaModiOneris

object DepositumDisciplinaModiOneris : DepositumNexuum<DisciplinaModiOneris>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_MODI_ONERIS
    override val nomenColumnae = NOMEN_COLUMNAE_MODUS_ONERIS_IDENTITAS
    override fun crea(
        disciplinaeIdentitas: DisciplinaeIdentitas,
        alterumIdentitas: Int
    ) = DisciplinaModiOneris(disciplinaeIdentitas, ModusOnerisIdentitas(alterumIdentitas))
}