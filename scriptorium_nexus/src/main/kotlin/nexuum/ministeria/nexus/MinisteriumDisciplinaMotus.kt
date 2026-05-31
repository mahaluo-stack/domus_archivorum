package org.example.nexuum.ministeria.nexus

import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas

class MinisteriumDisciplinaMotus : MinisteriumNexus<MotusIdentitas>() {
    override val nomenTabulae = "disciplina_motus"
    override val nomenColumnae = "motus_identitas"
    override fun identitas(identitas: MotusIdentitas): Int = identitas.valor
}