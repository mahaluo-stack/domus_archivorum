package servitium.disciplinarum

import ars_disciplina.disciplinarum.tabula.Disciplinae
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.registrum.disciplinarum.RegistrumDisciplinae
import commune.contractus.responsa.disciplinarum.ResponsumDisciplinae
import servitium.ServitiumLecturae
import translatores.disciplinarum.TranslatorDisciplinae

object ServitiumDisciplinae : ServitiumLecturae<DisciplinaeIdentitas, Disciplinae, ResponsumDisciplinae>() {

    override fun omniaEntia() = RegistrumDisciplinae.omnia()
    override fun invenireEntia(identitas: DisciplinaeIdentitas) = RegistrumDisciplinae.invenirePerClavemNecesse(identitas)
    override fun adResponsum(entia: Disciplinae): ResponsumDisciplinae = TranslatorDisciplinae.adResponsum(entia)
}