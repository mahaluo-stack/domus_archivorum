package servitium.nexuum

import ars_disciplina.RenovatorRegistrorum
import ars_disciplina.commune.registra.catalogus.RegistraMusculiRegioMusculi
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import ars_disciplina.nexuum.MinisteriumMusculiRegioMusculi
import ars_disciplina.nexuum.tabula.MusculiRegioMusculi
import ars_disciplina.registrum.nexuum.RegistrumMusculiRegioMusculi
import commune.constantia.ConstantiaResponsumDelereNexus
import commune.constantia.ConstantiaResponsumPonere
import commune.contractus.responsa.nexuum.ResponsumMusculiRegioMusculi
import servitium.ServitiumLecturaeNexuum
import translatores.nexuum.TranslatorMusculiMusculiRegio

object ServitiumMusculiRegioMusculi :
    ServitiumLecturaeNexuum<MusculiRegioIdentitas, MusculiRegioMusculi, ResponsumMusculiRegioMusculi>() {

    override fun omniaEntia() = RegistrumMusculiRegioMusculi.omnia()

    override fun adResponsum(entia: Set<MusculiRegioMusculi>): ResponsumMusculiRegioMusculi {
        return TranslatorMusculiMusculiRegio.adResponsum(entia)
    }

    override fun omnia(): Collection<ResponsumMusculiRegioMusculi> {
        return RegistrumMusculiRegioMusculi
            .omnia()
            .groupBy { it.musculiRegioIdentitas }
            .values
            .map(TranslatorMusculiMusculiRegio::adResponsum)
    }

    override fun omniaPerClavem(identitas: MusculiRegioIdentitas): Collection<ResponsumMusculiRegioMusculi> {
        return omnia().filter { it.musculiRegioIdentitas == identitas }.toSet()
    }

    fun ponereConfigurationem(
        musculiRegioIdentitas: MusculiRegioIdentitas, musculiIdentitates: Set<MusculiIdentitas>
    ): ConstantiaResponsumPonere {

        val actuales = RegistrumMusculiRegioMusculi.omniaPerClavem(musculiRegioIdentitas).map { it.musculiIdentitas }.toSet()

        MinisteriumMusculiRegioMusculi.delerePerClavem(musculiRegioIdentitas)

        musculiIdentitates.forEach { musculiIdentitas ->
            MinisteriumMusculiRegioMusculi.ponere(
                musculiRegioIdentitas, musculiIdentitas
            )
        }

        val responsum = if (actuales.isEmpty()) {
            ConstantiaResponsumPonere.CREATED
        } else if (actuales == musculiIdentitates) {
            ConstantiaResponsumPonere.UNCHANGED
        } else {
            ConstantiaResponsumPonere.UPDATED
        }

        RenovatorRegistrorum.renova(RegistraMusculiRegioMusculi)

        return responsum
    }

    fun delere(musculiRegioIdentitas: MusculiRegioIdentitas): ConstantiaResponsumDelereNexus =
        if (MinisteriumMusculiRegioMusculi.delerePerClavem(musculiRegioIdentitas) > 0) ConstantiaResponsumDelereNexus.SUCCESS
        else ConstantiaResponsumDelereNexus.NOT_FOUND
}