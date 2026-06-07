package ars_disciplina.registrum.regulorum

import ars_disciplina.commune.registra.RegistraRegulae
import ars_disciplina.regularum.tabula.Regulae
import ars_disciplina.regularum.valores.RegulaeIdentitas

object RegistrumRegulae {

    fun omnia(): Collection<Regulae> = RegistraRegulae.omnia()
    fun invenire(identitas: RegulaeIdentitas): Regulae = RegistraRegulae.invenirePerClavemNecesse(identitas)
}