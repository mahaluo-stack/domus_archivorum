package ars_disciplina.registrum.prehensionum

import ars_disciplina.commune.registra.catalogus.RegistraGeneraPrehensionis
import ars_disciplina.prehensionum.tabula.GeneraPrehensionis
import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas
import ars_disciplina.registrum.Registrum

object RegistrumGeneraPrehensionis : Registrum<GeneraPrehensionisIdentitas, GeneraPrehensionis>()  {

    override fun omnia() = RegistraGeneraPrehensionis.omnia()
    override fun invenire(identitas: GeneraPrehensionisIdentitas): GeneraPrehensionis = RegistraGeneraPrehensionis.invenirePerClavemNecesse(identitas)
}