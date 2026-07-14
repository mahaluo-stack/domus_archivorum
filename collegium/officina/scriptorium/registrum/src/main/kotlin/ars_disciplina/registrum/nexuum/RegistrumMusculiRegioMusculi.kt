package ars_disciplina.registrum.nexuum

import ars_disciplina.commune.registra.catalogus.RegistraMusculiRegioMusculi
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import ars_disciplina.nexuum.tabula.MusculiRegioMusculi
import ars_disciplina.registrum.RegistrumNexuum

object RegistrumMusculiRegioMusculi : RegistrumNexuum<MusculiRegioIdentitas, MusculiRegioMusculi>()  {
    override fun omnia(): Collection<MusculiRegioMusculi> = RegistraMusculiRegioMusculi.omnia()
    override fun omniaPerClavem(identitas: MusculiRegioIdentitas): Collection<MusculiRegioMusculi> = RegistraMusculiRegioMusculi.omniaPerClavemNecesse(identitas)
}