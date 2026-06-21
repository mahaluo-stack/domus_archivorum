package org.example.nexuum.ministeria.nexus

import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_PREHENSIONES_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_PREHENSIONES
import ars_disciplina.prehensionum.valores.identitas.PrehensionesIdentitas

object MinisteriumDisciplinaPrehensionesDisciplinae : MinisteriumNexusDisciplinae<PrehensionesIdentitas>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_PREHENSIONES
    override val nomenColumnae = NOMEN_COLUMNAE_PREHENSIONES_IDENTITAS
    override fun identitas(identitas: PrehensionesIdentitas): Int = identitas.valor
}