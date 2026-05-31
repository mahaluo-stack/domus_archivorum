package org.example.nexuum.ministeria.nexus

import ars_disciplina.disciplinarum.valores.identitas.VariationesIdentitas

class MinisteriumDisciplinaVariationes : MinisteriumNexus<VariationesIdentitas>() {
    override val nomenTabulae = "disciplina_variationes"
    override val nomenColumnae = "variationes_identitas"
    override fun identitas(identitas: VariationesIdentitas): Int = identitas.valor
}