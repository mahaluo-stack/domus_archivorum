package org.example.nexuum.ministeria.nexus

import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MOTUS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_MOTUS
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas

abstract class MinisteriumDisciplinaMotusDisciplinae : MinisteriumNexusDisciplinae<MotusIdentitas>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_MOTUS
    override val nomenColumnae = NOMEN_COLUMNAE_MOTUS_IDENTITAS
    override fun identitas(identitas: MotusIdentitas): Int = identitas.valor
}