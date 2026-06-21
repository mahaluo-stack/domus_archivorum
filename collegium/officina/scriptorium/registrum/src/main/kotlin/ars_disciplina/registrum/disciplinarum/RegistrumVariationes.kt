package ars_disciplina.registrum.disciplinarum

import ars_disciplina.disciplinarum.tabula.Motus
import ars_disciplina.disciplinarum.tabula.Variationes
import ars_disciplina.disciplinarum.valores.identitas.MotusIdentitas
import ars_disciplina.disciplinarum.valores.identitas.VariationesIdentitas
import ars_disciplina.registrum.Registrum
import org.example.commune.registrum.RegistraVariationes

object RegistrumVariationes : Registrum<VariationesIdentitas, Variationes>()  {

    override fun omnia(): Collection<Variationes> = RegistraVariationes.omnia()
    override fun invenire(identitas: VariationesIdentitas): Variationes = RegistraVariationes.invenirePerClavemNecesse(identitas)
}