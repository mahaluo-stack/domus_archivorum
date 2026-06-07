package ars_disciplina.registrum.disciplinarum

import ars_disciplina.disciplinarum.tabula.Variationes
import ars_disciplina.disciplinarum.valores.identitas.VariationesIdentitas
import org.example.commune.registrum.RegistraVariationes

object RegistrumVariationes {

    fun omnia(): Collection<Variationes> = RegistraVariationes.omnia()
    fun invenire(identitas: VariationesIdentitas): Variationes = RegistraVariationes.invenirePerClavemNecesse(identitas)
}