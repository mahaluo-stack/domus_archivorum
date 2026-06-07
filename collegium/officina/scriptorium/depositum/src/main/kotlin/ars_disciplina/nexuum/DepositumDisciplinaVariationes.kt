package ars_disciplina.nexuum

import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_VARIATIONES_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_VARIATIONES
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.disciplinarum.valores.identitas.VariationesIdentitas
import ars_disciplina.nexuum.tabula.DisciplinaVariationes

object DepositumDisciplinaVariationes : DepositumNexuum<DisciplinaVariationes>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_VARIATIONES
    override val nomenColumnaeAlterumIdentitas = NOMEN_COLUMNAE_VARIATIONES_IDENTITAS
    override fun crea(
        disciplinaeIdentitas: DisciplinaeIdentitas,
        alterumIdentitas: Int
    ) = DisciplinaVariationes(disciplinaeIdentitas, VariationesIdentitas(alterumIdentitas))
}