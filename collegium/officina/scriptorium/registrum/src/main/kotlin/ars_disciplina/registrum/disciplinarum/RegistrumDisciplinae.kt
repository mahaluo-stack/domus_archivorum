package ars_disciplina.registrum.disciplinarum

import ars_disciplina.disciplinarum.tabula.Disciplinae
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.registrum.Registrum
import org.example.commune.registrum.RegistraDisciplinae

object RegistrumDisciplinae : Registrum<DisciplinaeIdentitas, Disciplinae>() {
    override fun omnia(): Collection<Disciplinae> = RegistraDisciplinae.omnia()
    override fun invenirePerClavemNecesse(identitas: DisciplinaeIdentitas): Disciplinae = RegistraDisciplinae.invenirePerClavemNecesse(identitas)
    override fun invenireSiAdest(identitas: DisciplinaeIdentitas): Disciplinae? = RegistraDisciplinae.invenireSiAdest(identitas)
}