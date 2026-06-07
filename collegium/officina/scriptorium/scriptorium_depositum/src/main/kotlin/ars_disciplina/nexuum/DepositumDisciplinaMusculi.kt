package ars_disciplina.nexuum

import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MUSCULI_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_MUSCULI
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.nexuum.tabula.DisciplinaMusculi

object DepositumDisciplinaMusculi : DepositumNexuum<DisciplinaMusculi>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_MUSCULI
    override val nomenColumnaeAlterumIdentitas = NOMEN_COLUMNAE_MUSCULI_IDENTITAS
    override fun crea(
        disciplinaeIdentitas: DisciplinaeIdentitas,
        alterumIdentitas: Int
    ) = DisciplinaMusculi(disciplinaeIdentitas, MusculiIdentitas(alterumIdentitas))
}