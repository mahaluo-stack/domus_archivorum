package ars_disciplina.nexuum

import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MUSCULI_PARS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_MUSCULI_PARS
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.nexuum.tabula.DisciplinaMusculiPars

object DepositumDisciplinaMusculiPars : DepositumNexuum<DisciplinaMusculiPars>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_MUSCULI_PARS
    override val nomenColumnaeAlterumIdentitas = NOMEN_COLUMNAE_MUSCULI_PARS_IDENTITAS
    override fun crea(
        disciplinaeIdentitas: DisciplinaeIdentitas,
        alterumIdentitas: Int
    ) = DisciplinaMusculiPars(disciplinaeIdentitas, MusculiParsIdentitas(alterumIdentitas))
}