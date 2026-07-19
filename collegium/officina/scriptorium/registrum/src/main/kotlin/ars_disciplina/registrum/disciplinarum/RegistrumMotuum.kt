package ars_disciplina.registrum.disciplinarum

import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import ars_disciplina.registrum.Registrum
import org.example.commune.registrum.RegistraMotus

object RegistrumMotuum : Registrum<MotusIdentitas, Motus>() {

    override fun omnia() = RegistraMotus.omnia()
    override fun invenirePerClavemNecesse(identitas: MotusIdentitas) = RegistraMotus.invenirePerClavemNecesse(identitas)
    override fun invenireSiAdest(identitas: MotusIdentitas): Motus? = RegistraMotus.invenireSiAdest(identitas)
}