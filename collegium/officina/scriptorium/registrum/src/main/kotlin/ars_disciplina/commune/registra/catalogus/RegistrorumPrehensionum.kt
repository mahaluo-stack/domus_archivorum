package ars_disciplina.commune.registra.catalogus

import ars_disciplina.prehensionum.tabula.GeneraPrehensionis
import ars_disciplina.prehensionum.tabula.Prehensiones
import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas
import ars_disciplina.prehensionum.valores.identitas.PrehensionesIdentitas
import org.example.commune.registrum.Registra

object RegistraPrehensiones : Registra<PrehensionesIdentitas, Prehensiones>({ it.prehensionesIdentitas })
object RegistraGeneraPrehensionis : Registra<GeneraPrehensionisIdentitas, GeneraPrehensionis>({ it.generaPrehensionisIdentitas })