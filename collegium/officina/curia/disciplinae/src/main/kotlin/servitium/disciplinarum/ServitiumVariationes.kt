package servitium.disciplinarum

import ars_disciplina.disciplinarum.tabula.Variationes
import ars_disciplina.disciplinarum.valores.identitas.VariationesIdentitas
import ars_disciplina.registrum.disciplinarum.RegistrumVariationes
import commune.contractus.responsa.disciplinarum.ResponsumVariationes
import org.example.commune.registrum.RegistraVariationes
import servitium.ServitiumLecturae
import translatores.disciplinarum.TranslatorVariationes

object ServitiumVariationes : ServitiumLecturae<VariationesIdentitas, Variationes, ResponsumVariationes>() {

    override fun omniaEntia() = RegistraVariationes.omnia()
    override fun invenireEntia(identitas: VariationesIdentitas) = RegistrumVariationes.invenire(identitas)
    override fun adResponsum(entia: Variationes) = TranslatorVariationes.adResponsum(entia)
}