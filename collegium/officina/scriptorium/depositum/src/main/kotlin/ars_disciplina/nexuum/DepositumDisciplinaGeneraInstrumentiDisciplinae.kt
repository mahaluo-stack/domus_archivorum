package ars_disciplina.nexuum

import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_GENERA_INSTRUMENTI_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_GENERA_INSTRUMENTI
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.instrumentorum.valores.identitas.GenusInstrumentiIdentitas
import ars_disciplina.nexuum.tabula.DisciplinaGeneraInstrumenti

object DepositumDisciplinaGeneraInstrumentiDisciplinae : DepositumNexuumDisciplinae<DisciplinaGeneraInstrumenti>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_GENERA_INSTRUMENTI
    override val nomenColumnaeAlterumIdentitas = NOMEN_COLUMNAE_GENERA_INSTRUMENTI_IDENTITAS
    override fun crea(
        disciplinaeIdentitas: DisciplinaeIdentitas,
        alterumIdentitas: Int
    ) = DisciplinaGeneraInstrumenti(disciplinaeIdentitas, GenusInstrumentiIdentitas(alterumIdentitas))
}