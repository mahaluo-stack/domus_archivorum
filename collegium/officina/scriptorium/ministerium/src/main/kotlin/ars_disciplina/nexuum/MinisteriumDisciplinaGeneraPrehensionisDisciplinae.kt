package org.example.nexuum.ministeria.nexus

import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_GENERA_PREHENSIONIS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_GENERA_PREHENSIONIS
import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas

abstract class MinisteriumDisciplinaGeneraPrehensionisDisciplinae : MinisteriumNexusDisciplinae<GeneraPrehensionisIdentitas>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_GENERA_PREHENSIONIS
    override val nomenColumnae = NOMEN_COLUMNAE_GENERA_PREHENSIONIS_IDENTITAS
    override fun identitas(identitas: GeneraPrehensionisIdentitas): Int = identitas.valor
}