package ars_disciplina.nexuum

import ars_disciplina.classificationum.valores.identitas.GeneraDisciplinaeIdentitas
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_NOMEN_GENUS_DISCIPLINAE
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_GENERA_DISCIPLINAE
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.nexuum.tabula.DisciplinaGeneraDisciplinae

object DepositumDisciplinaGeneraDisciplinae : DepositumNexuum<DisciplinaGeneraDisciplinae>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_GENERA_DISCIPLINAE
    override val nomenColumnae = NOMEN_COLUMNAE_NOMEN_GENUS_DISCIPLINAE
    override fun crea(
        disciplinaeIdentitas: DisciplinaeIdentitas,
        alterumIdentitas: Int
    ) = DisciplinaGeneraDisciplinae(disciplinaeIdentitas, GeneraDisciplinaeIdentitas(alterumIdentitas))
}