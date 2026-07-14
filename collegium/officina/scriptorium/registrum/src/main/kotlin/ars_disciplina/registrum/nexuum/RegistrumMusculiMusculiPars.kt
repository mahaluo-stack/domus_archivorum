package ars_disciplina.registrum.nexuum

import ars_disciplina.commune.registra.catalogus.RegistraMusculiMusculiPars
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.nexuum.tabula.MusculiMusculiPars
import ars_disciplina.registrum.RegistrumNexuum

object RegistrumMusculiMusculiPars : RegistrumNexuum<MusculiIdentitas, MusculiMusculiPars>()  {
    override fun omnia(): Collection<MusculiMusculiPars> = RegistraMusculiMusculiPars.omnia()
    override fun omniaPerClavem(identitas: MusculiIdentitas): Collection<MusculiMusculiPars> = RegistraMusculiMusculiPars.omniaPerClavem(identitas)
}