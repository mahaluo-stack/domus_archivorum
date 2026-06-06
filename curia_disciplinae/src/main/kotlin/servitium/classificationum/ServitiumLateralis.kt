package servitium.classificationum

import ars_disciplina.classificationum.tabula.Lateralis
import ars_disciplina.classificationum.valores.identitas.LateralisIdentitas
import ars_disciplina.registrum.classificationum.RegistrumLateralis
import commune.contractus.responsa.classificationum.ResponsumLateralis
import servitium.ServitiumLecturae
import translatores.classificationum.TranslatorLateralis

object ServitiumLateralis : ServitiumLecturae<LateralisIdentitas, Lateralis, ResponsumLateralis>() {

    override fun omniaEntia() = RegistrumLateralis.omnia()
    override fun invenireEntia(identitas: LateralisIdentitas) = RegistrumLateralis.invenire(identitas)
    override fun adResponsum(entia: Lateralis): ResponsumLateralis = TranslatorLateralis.adResponsum(entia)
}