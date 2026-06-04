package ars_disciplina.commune.registrum

import ars_disciplina.disciplinarum.tabula.Archetypus
import ars_disciplina.disciplinarum.valores.NomenArchetypi
import org.example.commune.registrum.Registra

object RegistraArchetypi : Registra<NomenArchetypi, Archetypus>(
    { it.nomenArchetypi }
)