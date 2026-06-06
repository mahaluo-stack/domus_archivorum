package ars_disciplina.registrum.disciplinarum

import ars_disciplina.disciplinarum.tabula.Angulus
import ars_disciplina.disciplinarum.valores.identitas.AngulusIdentitas
import org.example.commune.registrum.RegistraAngulus

object RegistrumAngulus {

    fun omnia(): Collection<Angulus> = RegistraAngulus.omnia()
    fun invenire(identitas: AngulusIdentitas): Angulus = RegistraAngulus.invenirePerClavemNecesse(identitas)
}