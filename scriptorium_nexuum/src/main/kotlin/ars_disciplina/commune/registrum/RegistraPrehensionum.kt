package ars_disciplina.commune.registrum

import ars_disciplina.prehensionum.tabula.GeneraPrehensionis
import ars_disciplina.prehensionum.tabula.Prehensiones
import ars_disciplina.prehensionum.valores.NomenGeneraPrehensionis
import ars_disciplina.prehensionum.valores.NomenPrehensionis
import org.example.commune.registrum.Registra

object RegistraPrehensiones : Registra<NomenPrehensionis, Prehensiones>({ it.nomen })
object RegistraGeneraPrehensionis : Registra<NomenGeneraPrehensionis, GeneraPrehensionis>({ it.nomen })