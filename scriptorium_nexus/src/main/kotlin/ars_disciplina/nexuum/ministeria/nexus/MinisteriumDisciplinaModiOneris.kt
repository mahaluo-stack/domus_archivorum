package org.example.nexuum.ministeria.nexus

import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas
import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas

class MinisteriumDisciplinaModiOneris : MinisteriumNexus<ModusOnerisIdentitas>() {
    override val nomenTabulae = "disciplina_modi_oneris"
    override val nomenColumnae = "modus_oneris_identitas"
    override fun identitas(identitas: ModusOnerisIdentitas): Int = identitas.valor
}