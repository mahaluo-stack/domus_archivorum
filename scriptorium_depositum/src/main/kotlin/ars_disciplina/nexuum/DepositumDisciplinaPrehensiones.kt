package ars_disciplina.nexuum

import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_PREHENSIONES_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_PREHENSIONES
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.nexuum.tabula.DisciplinaPrehensiones
import ars_disciplina.prehensionum.valores.identitas.PrehensionesIdentitas

object DepositumDisciplinaPrehensiones : DepositumNexuum<DisciplinaPrehensiones>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_PREHENSIONES
    override val nomenColumnae = NOMEN_COLUMNAE_PREHENSIONES_IDENTITAS
    override fun crea(
        disciplinaeIdentitas: DisciplinaeIdentitas,
        alterumIdentitas: Int
    ) = DisciplinaPrehensiones(disciplinaeIdentitas, PrehensionesIdentitas(alterumIdentitas))
}