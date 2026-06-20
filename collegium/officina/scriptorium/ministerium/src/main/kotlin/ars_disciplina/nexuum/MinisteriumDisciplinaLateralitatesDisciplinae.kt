package org.example.nexuum.ministeria.nexus

import ars_disciplina.classificationum.valores.identitas.LateralisIdentitas
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_LATERALIS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_LATERALITATES

abstract class MinisteriumDisciplinaLateralitatesDisciplinae : MinisteriumNexusDisciplinae<LateralisIdentitas>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_LATERALITATES
    override val nomenColumnae = NOMEN_COLUMNAE_LATERALIS_IDENTITAS
    override fun identitas(identitas: LateralisIdentitas): Int = identitas.valor
}