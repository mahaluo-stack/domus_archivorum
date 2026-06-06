package ars_disciplina.commune.registra

import ars_disciplina.regularum.tabula.Regulae
import ars_disciplina.regularum.valores.NomenRegulae
import org.example.commune.registrum.Registra

object RegistraRegularum : Registra<NomenRegulae, Regulae>({ it.nomen })