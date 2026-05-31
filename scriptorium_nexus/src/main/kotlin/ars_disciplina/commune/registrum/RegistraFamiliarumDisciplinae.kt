package ars_disciplina.commune.registrum

import org.example.commune.exemplaria.interfacia.FamiliaDisciplinae
import org.example.commune.registrum.Registra

object RegistraFamiliarumDisciplinae : Registra<String, FamiliaDisciplinae>(
    { it.nomenFamiliae.lowercase() }
)