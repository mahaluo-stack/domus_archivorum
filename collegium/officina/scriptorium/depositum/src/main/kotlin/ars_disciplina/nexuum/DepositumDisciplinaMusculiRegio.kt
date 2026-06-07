package ars_disciplina.nexuum

import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MUSCULI_REGIO_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_MUSCULI_REGIO
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import ars_disciplina.nexuum.tabula.DisciplinaMusculiRegio

object DepositumDisciplinaMusculiRegio : DepositumNexuum<DisciplinaMusculiRegio>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_MUSCULI_REGIO
    override val nomenColumnaeAlterumIdentitas = NOMEN_COLUMNAE_MUSCULI_REGIO_IDENTITAS
    override fun crea(
        disciplinaeIdentitas: DisciplinaeIdentitas,
        alterumIdentitas: Int
    ) = DisciplinaMusculiRegio(disciplinaeIdentitas, MusculiRegioIdentitas(alterumIdentitas))
}