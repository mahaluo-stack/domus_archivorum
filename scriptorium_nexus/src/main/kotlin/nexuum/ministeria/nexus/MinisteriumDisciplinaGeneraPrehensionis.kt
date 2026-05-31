package org.example.nexuum.ministeria.nexus

import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas

class MinisteriumDisciplinaGeneraPrehensionis : MinisteriumNexus<GeneraPrehensionisIdentitas>() {
    override val nomenTabulae = "disciplina_genera_prehensionis"
    override val nomenColumnae = "genera_prehensionis_identitas"
    override fun identitas(identitas: GeneraPrehensionisIdentitas): Int = identitas.valor
}