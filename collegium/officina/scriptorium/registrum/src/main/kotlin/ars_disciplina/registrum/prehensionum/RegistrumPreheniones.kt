package ars_disciplina.registrum.prehensionum

import ars_disciplina.commune.registra.RegistraPrehensiones
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import ars_disciplina.prehensionum.tabula.Prehensiones
import ars_disciplina.prehensionum.valores.identitas.PrehensionesIdentitas
import ars_disciplina.registrum.Registrum

object RegistrumPreheniones : Registrum<PrehensionesIdentitas, Prehensiones>()  {

    override fun omnia(): Collection<Prehensiones> = RegistraPrehensiones.omnia()
    override fun invenire(identitas: PrehensionesIdentitas): Prehensiones = RegistraPrehensiones.invenirePerClavemNecesse(identitas)
}