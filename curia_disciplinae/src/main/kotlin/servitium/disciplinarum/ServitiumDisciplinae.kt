package servitium.disciplinarum

import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.registrum.RegistrumDisciplinae
import commune.contractus.responsa.ResponsumDisciplinae
import translatores.disciplinarum.TranslatorDisciplinae

object ServitiumDisciplinae {

    fun omnia(): Collection<ResponsumDisciplinae> =
        RegistrumDisciplinae.omniaDisciplinae().map(TranslatorDisciplinae::adResponsum)

    fun invenire(identitas: DisciplinaeIdentitas): ResponsumDisciplinae =
        TranslatorDisciplinae.adResponsum(RegistrumDisciplinae.invenireDisciplinae(identitas))
}