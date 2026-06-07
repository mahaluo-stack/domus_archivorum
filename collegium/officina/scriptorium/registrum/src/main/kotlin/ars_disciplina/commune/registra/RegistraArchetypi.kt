package ars_disciplina.commune.registra

import ars_disciplina.disciplinarum.tabula.Archetypus
import ars_disciplina.disciplinarum.valores.identitas.ArchetypusIdentitas
import org.example.commune.registrum.Registra

object RegistraArchetypi : Registra<ArchetypusIdentitas, Archetypus>({ it.archetypiIdentitas })