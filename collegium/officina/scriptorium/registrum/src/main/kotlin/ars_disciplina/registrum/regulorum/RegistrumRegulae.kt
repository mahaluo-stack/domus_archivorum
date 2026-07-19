package ars_disciplina.registrum.regulorum

import ars_disciplina.commune.registra.catalogus.RegistraRegulae
import ars_disciplina.registrum.Registrum
import ars_disciplina.regularum.tabula.Regulae
import ars_disciplina.regularum.valores.RegulaeIdentitas

object RegistrumRegulae : Registrum<RegulaeIdentitas, Regulae>()  {

    override fun omnia(): Collection<Regulae> = RegistraRegulae.omnia()
    override fun invenirePerClavemNecesse(identitas: RegulaeIdentitas): Regulae = RegistraRegulae.invenirePerClavemNecesse(identitas)
    override fun invenireSiAdest(identitas: RegulaeIdentitas): Regulae? = RegistraRegulae.invenireSiAdest(identitas)
}