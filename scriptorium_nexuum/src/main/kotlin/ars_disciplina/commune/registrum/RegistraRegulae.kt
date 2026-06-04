package ars_disciplina.commune.registrum

import ars_disciplina.regularum.tabula.Regulae
import ars_disciplina.regularum.valores.NomenRegulae
import org.example.commune.registrum.Registra

object RegistraRegulae : Registra<NomenRegulae, Regulae>({ it.nomen })