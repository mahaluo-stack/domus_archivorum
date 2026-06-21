package org.example.nexuum.ministeria.nexus

import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MODUS_ONERIS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_MODI_ONERIS

object MinisteriumDisciplinaModiOnerisDisciplinae : MinisteriumNexusDisciplinae<ModusOnerisIdentitas>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_MODI_ONERIS
    override val nomenColumnae = NOMEN_COLUMNAE_MODUS_ONERIS_IDENTITAS
    override fun identitas(identitas: ModusOnerisIdentitas): Int = identitas.valor
}