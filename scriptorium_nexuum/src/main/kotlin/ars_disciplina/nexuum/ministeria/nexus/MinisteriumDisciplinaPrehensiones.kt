package org.example.nexuum.ministeria.nexus

import ars_disciplina.prehensionum.valores.identitas.PrehensionesIdentitas

class MinisteriumDisciplinaPrehensiones : MinisteriumNexus<PrehensionesIdentitas>() {
    override val nomenTabulae = "disciplina_prehensiones"
    override val nomenColumnae = "prehensiones_identitas"
    override fun identitas(identitas: PrehensionesIdentitas): Int = identitas.valor
}