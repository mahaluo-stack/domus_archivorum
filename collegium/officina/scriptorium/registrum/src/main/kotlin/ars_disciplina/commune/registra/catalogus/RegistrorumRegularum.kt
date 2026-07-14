package ars_disciplina.commune.registra.catalogus

import ars_disciplina.regularum.tabula.Regulae
import ars_disciplina.regularum.valores.RegulaeIdentitas
import org.example.commune.registrum.Registra

object RegistraRegulae : Registra<RegulaeIdentitas, Regulae>({ it.regulaeIdentitas })