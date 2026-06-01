package ars_disciplina.commune.registrum

import org.example.commune.exemplaria.interfacia.ArchetypusDisciplinae
import org.example.commune.registrum.Registra

object RegistraArchetyporum : Registra<String, ArchetypusDisciplinae>(
    { it.nomenArchetypi.lowercase() }
)