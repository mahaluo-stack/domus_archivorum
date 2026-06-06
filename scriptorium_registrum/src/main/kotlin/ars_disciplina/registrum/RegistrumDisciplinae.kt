package ars_disciplina.registrum

import ars_disciplina.commune.exemplaria.FabricaEntiaDisciplinae
import ars_disciplina.disciplinarum.entia.EntiaDisciplina
import ars_disciplina.disciplinarum.tabula.Disciplinae
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import org.example.commune.registrum.RegistraDisciplinae

object RegistrumDisciplinae {

    fun omniaDisciplinae(): Collection<Disciplinae> = RegistraDisciplinae.omnia()
    fun invenireDisciplinae(identitas: DisciplinaeIdentitas): Disciplinae =
        RegistraDisciplinae.invenirePerClavemNecesse(identitas)

    fun omniaEntia(): Set<EntiaDisciplina> =
        RegistraDisciplinae.omnia()
            .map {
                FabricaEntiaDisciplinae.crea(
                    it.disciplinaeIdentitas
                )
            }
            .toSet()

    fun invenireEntia(identitas: DisciplinaeIdentitas): EntiaDisciplina =
        FabricaEntiaDisciplinae.crea(identitas)
}