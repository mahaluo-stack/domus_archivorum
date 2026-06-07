package ars_disciplina.registrum.prehensionum

import ars_disciplina.commune.registra.RegistraGeneraPrehensionis
import ars_disciplina.prehensionum.tabula.GeneraPrehensionis
import ars_disciplina.prehensionum.valores.identitas.GeneraPrehensionisIdentitas

object RegistrumGeneraPrehensionis {

    fun omnia(): Collection<GeneraPrehensionis> = RegistraGeneraPrehensionis.omnia()
    fun invenire(identitas: GeneraPrehensionisIdentitas): GeneraPrehensionis = RegistraGeneraPrehensionis.invenirePerClavemNecesse(identitas)
}