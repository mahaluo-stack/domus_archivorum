package servitium.nexuum

import ars_disciplina.RenovatorRegistrorum
import ars_disciplina.commune.registra.RegistraMusculiMusculiPars
import ars_disciplina.commune.registra.RegistraMusculiRegioMusculi
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.nexuum.MinisteriumMusculiMusculiPars
import ars_disciplina.nexuum.MinisteriumMusculiRegioMusculi
import ars_disciplina.nexuum.tabula.MusculiMusculiPars
import ars_disciplina.registrum.nexuum.RegistrumMusculiMusculiPars
import ars_disciplina.registrum.nexuum.RegistrumMusculiRegioMusculi
import commune.constantia.ConstantiaResponsumDelere
import commune.constantia.ConstantiaResponsumPonere
import commune.contractus.responsa.nexuum.ResponsumMusculiMusculiPars
import servitium.ServitiumLecturaeNexuum
import translatores.nexuum.TranslatorMusculiMusculiPars

object ServitiumMusculiMusculiPars :
    ServitiumLecturaeNexuum<MusculiIdentitas, MusculiMusculiPars, ResponsumMusculiMusculiPars>() {

    override fun omniaEntia() = RegistrumMusculiMusculiPars.omnia()
    override fun adResponsum(entia: Set<MusculiMusculiPars>): ResponsumMusculiMusculiPars =
        TranslatorMusculiMusculiPars.adResponsum(entia)

    override fun omnia(): Collection<ResponsumMusculiMusculiPars> {
        return RegistrumMusculiMusculiPars.omnia().groupBy { it.musculiIdentitas }.values.map(
                TranslatorMusculiMusculiPars::adResponsum
            )
    }

    override fun omniaPerClavem(identitas: MusculiIdentitas): Collection<ResponsumMusculiMusculiPars> {
        return omnia().filter { it.musculiIdentitas == identitas }.toSet()
    }

    fun ponereConfigurationem(
        musculiIdentitas: MusculiIdentitas, musculiParsIdentitates: Set<MusculiParsIdentitas>
    ): ConstantiaResponsumPonere {

        val actuales =
            RegistrumMusculiMusculiPars.omniaPerClavem(musculiIdentitas).map { it.musculiParsIdentitas }.toSet()

        MinisteriumMusculiMusculiPars.delerePerClavem(musculiIdentitas)

        musculiParsIdentitates.forEach { musculiParsIdentitas ->
            MinisteriumMusculiMusculiPars.ponere(
                musculiIdentitas, musculiParsIdentitas
            )
        }

        val responsum = if (actuales.isEmpty()) {
            ConstantiaResponsumPonere.CREATED
        } else if (actuales == musculiParsIdentitates) {
            ConstantiaResponsumPonere.UNCHANGED
        } else {
            ConstantiaResponsumPonere.UPDATED
        }

        RenovatorRegistrorum.renova(RegistraMusculiMusculiPars)

        return responsum
    }

    fun delere(musculiIdentitas: MusculiIdentitas): ConstantiaResponsumDelere =
        if (MinisteriumMusculiMusculiPars.delerePerClavem(musculiIdentitas) > 0) ConstantiaResponsumDelere.SUCCESS
        else ConstantiaResponsumDelere.NOT_FOUND

}