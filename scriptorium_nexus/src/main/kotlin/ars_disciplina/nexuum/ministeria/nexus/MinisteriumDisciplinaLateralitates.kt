package org.example.nexuum.ministeria.nexus

import ars_disciplina.classificationum.valores.identitas.LateralisIdentitas

class MinisteriumDisciplinaLateralitates : MinisteriumNexus<LateralisIdentitas>() {
    override val nomenTabulae = "disciplina_lateralitates"
    override val nomenColumnae = "lateralis_identitas"
    override fun identitas(identitas: LateralisIdentitas): Int = identitas.valor
}