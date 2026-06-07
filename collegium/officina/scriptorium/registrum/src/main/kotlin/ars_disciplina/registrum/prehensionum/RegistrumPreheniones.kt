package ars_disciplina.registrum.prehensionum

import ars_disciplina.commune.registra.RegistraPrehensiones
import ars_disciplina.prehensionum.tabula.Prehensiones
import ars_disciplina.prehensionum.valores.identitas.PrehensionesIdentitas

object RegistrumPreheniones {

    fun omnia(): Collection<Prehensiones> = RegistraPrehensiones.omnia()
    fun invenire(identitas: PrehensionesIdentitas): Prehensiones = RegistraPrehensiones.invenirePerClavemNecesse(identitas)
}