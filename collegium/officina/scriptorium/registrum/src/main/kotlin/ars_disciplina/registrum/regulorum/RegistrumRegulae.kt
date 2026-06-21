package ars_disciplina.registrum.regulorum

import ars_disciplina.commune.registra.RegistraRegulae
import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import ars_disciplina.registrum.Registrum
import ars_disciplina.regularum.tabula.Regulae
import ars_disciplina.regularum.valores.RegulaeIdentitas

object RegistrumRegulae : Registrum<RegulaeIdentitas, Regulae>()  {

    override fun omnia(): Collection<Regulae> = RegistraRegulae.omnia()
    override fun invenire(identitas: RegulaeIdentitas): Regulae = RegistraRegulae.invenirePerClavemNecesse(identitas)
}