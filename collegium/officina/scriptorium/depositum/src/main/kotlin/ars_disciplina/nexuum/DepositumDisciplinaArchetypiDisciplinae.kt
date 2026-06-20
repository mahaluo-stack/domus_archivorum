package ars_disciplina.nexuum

import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_ARCHETYPUS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_ARCHETYPI
import ars_disciplina.disciplinarum.valores.identitas.ArchetypusIdentitas
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.nexuum.tabula.DisciplinaArchetypi

object DepositumDisciplinaArchetypiDisciplinae : DepositumNexuumDisciplinae<DisciplinaArchetypi>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_ARCHETYPI
    override val nomenColumnaeAlterumIdentitas = NOMEN_COLUMNAE_ARCHETYPUS_IDENTITAS
    override fun crea(
        disciplinaeIdentitas: DisciplinaeIdentitas,
        alterumIdentitas: Int
    ) = DisciplinaArchetypi(disciplinaeIdentitas, ArchetypusIdentitas(alterumIdentitas))
}