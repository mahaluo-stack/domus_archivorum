package ars_disciplina.registrum.disciplinarum

import ars_disciplina.classificationum.tabula.ModusOneris
import ars_disciplina.classificationum.valores.identitas.ModusOnerisIdentitas
import ars_disciplina.disciplinarum.tabula.Angulus
import ars_disciplina.disciplinarum.valores.identitas.AngulusIdentitas
import ars_disciplina.registrum.Registrum
import org.example.commune.registrum.RegistraAngulus

object RegistrumAngulus : Registrum<AngulusIdentitas, Angulus>() {

    override fun omnia(): Collection<Angulus> = RegistraAngulus.omnia()
    override fun invenire(identitas: AngulusIdentitas): Angulus = RegistraAngulus.invenirePerClavemNecesse(identitas)
}