package ars_disciplina.nexuum

import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_INSTRUMENTA_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_INSTRUMENTI
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.instrumentorum.valores.identitas.InstrumentaIdentitas
import ars_disciplina.nexuum.tabula.DisciplinaInstrumenti


object DepositumDisciplinaInstrumenti : DepositumNexuum<DisciplinaInstrumenti>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_INSTRUMENTI
    override val nomenColumnaeAlterumIdentitas = NOMEN_COLUMNAE_INSTRUMENTA_IDENTITAS
    override fun crea(
        disciplinaeIdentitas: DisciplinaeIdentitas,
        alterumIdentitas: Int
    ) = DisciplinaInstrumenti(disciplinaeIdentitas, InstrumentaIdentitas(alterumIdentitas))
}