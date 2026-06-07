package org.example.nexuum.ministeria.nexus

import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_ANGULUS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_ANGULI
import ars_disciplina.disciplinarum.valores.identitas.AngulusIdentitas

abstract class MinisteriumDisciplinaAnguli : MinisteriumNexus<AngulusIdentitas>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_ANGULI
    override val nomenColumnae = NOMEN_COLUMNAE_ANGULUS_IDENTITAS
    override fun identitas(identitas: AngulusIdentitas): Int = identitas.valor
}