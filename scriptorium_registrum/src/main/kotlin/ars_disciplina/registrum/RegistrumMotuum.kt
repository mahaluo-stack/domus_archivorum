package ars_disciplina.registrum

import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import org.example.commune.registrum.RegistraMotus

object RegistrumMotuum : Registrum<MotusIdentitas, Motus>() {

    override fun omnia() = RegistraMotus.omnia()
    override fun invenire(identitas: MotusIdentitas) = RegistraMotus.invenirePerClavemNecesse(identitas)
}