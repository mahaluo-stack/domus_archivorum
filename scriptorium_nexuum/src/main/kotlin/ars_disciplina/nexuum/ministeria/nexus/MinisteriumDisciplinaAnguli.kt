package org.example.nexuum.ministeria.nexus

import ars_disciplina.disciplinarum.valores.identitas.AngulusIdentitas

class MinisteriumDisciplinaAnguli : MinisteriumNexus<AngulusIdentitas>() {
    override val nomenTabulae = "disciplina_anguli"
    override val nomenColumnae = "angulus_identitas"
    override fun identitas(identitas: AngulusIdentitas): Int = identitas.valor
}