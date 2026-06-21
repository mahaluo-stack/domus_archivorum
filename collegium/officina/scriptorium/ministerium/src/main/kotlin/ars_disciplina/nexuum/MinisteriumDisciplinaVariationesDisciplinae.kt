package org.example.nexuum.ministeria.nexus

import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_VARIATIONES_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_DISCIPLINA_VARIATIONES
import ars_disciplina.disciplinarum.valores.identitas.VariationesIdentitas

object MinisteriumDisciplinaVariationesDisciplinae : MinisteriumNexusDisciplinae<VariationesIdentitas>() {
    override val nomenTabulae = NOMEN_TABULAE_DISCIPLINA_VARIATIONES
    override val nomenColumnae = NOMEN_COLUMNAE_VARIATIONES_IDENTITAS
    override fun identitas(identitas: VariationesIdentitas): Int = identitas.valor
}