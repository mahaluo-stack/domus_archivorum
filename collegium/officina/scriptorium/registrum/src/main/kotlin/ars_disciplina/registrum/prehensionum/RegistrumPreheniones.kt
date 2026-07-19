package ars_disciplina.registrum.prehensionum

import ars_disciplina.commune.registra.catalogus.RegistraPrehensiones
import ars_disciplina.prehensionum.tabula.Prehensiones
import ars_disciplina.prehensionum.valores.identitas.PrehensionesIdentitas
import ars_disciplina.registrum.Registrum

object RegistrumPreheniones : Registrum<PrehensionesIdentitas, Prehensiones>()  {

    override fun omnia(): Collection<Prehensiones> = RegistraPrehensiones.omnia()
    override fun invenirePerClavemNecesse(identitas: PrehensionesIdentitas): Prehensiones = RegistraPrehensiones.invenirePerClavemNecesse(identitas)
    override fun invenireSiAdest(identitas: PrehensionesIdentitas): Prehensiones? = RegistraPrehensiones.invenireSiAdest(identitas)
}