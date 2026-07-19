package servitium.musculorum

import ars_disciplina.RenovatorRegistrorum
import ars_disciplina.commune.registra.catalogus.RegistraMusculi
import ars_disciplina.commune.registra.catalogus.RegistraMusculiMusculiPars
import ars_disciplina.commune.registra.catalogus.RegistraMusculiRegioMusculi
import ars_disciplina.musculorum.MinisteriumMusculi
import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculi
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.nexuum.MinisteriumMusculiMusculiPars
import ars_disciplina.nexuum.MinisteriumMusculiRegioMusculi
import ars_disciplina.registrum.musculorum.RegistrumMusculi
import commune.constantia.ConstantiaResponsumCreata
import commune.constantia.ConstantiaResponsumDelereRegistra
import commune.constantia.ConstantiaResponsumPonere
import commune.contractus.petitio.musculorum.PetitioMusculi
import commune.contractus.responsa.musculorum.ResponsumMusculi
import org.example.exemplaria.tabulae.Musculi
import servitium.ServitiumLecturae
import translatores.musculorum.TranslatorMusculi

object ServitiumMusculi : ServitiumLecturae<MusculiIdentitas, Musculi, ResponsumMusculi>() {

    override fun omniaEntia() = RegistrumMusculi.omnia()
    override fun invenireEntia(identitas: MusculiIdentitas) = RegistrumMusculi.invenirePerClavemNecesse(identitas)
    override fun adResponsum(entia: Musculi): ResponsumMusculi = TranslatorMusculi.adResponsum(entia)

    fun invenireSiAdest(identitas: MusculiIdentitas): ResponsumMusculi? =
        RegistraMusculi.invenireSiAdest(identitas)?.let(::adResponsum)

    fun ponere(petitioMusculi: PetitioMusculi): ConstantiaResponsumPonere {

        val musculiIdentitas = MusculiIdentitas(petitioMusculi.identitas)
        val nomenMusculi = NomenMusculi(petitioMusculi.nomen)
        val descriptioMusculi = DescriptioMusculi(petitioMusculi.descriptio)

        val actuales = RegistrumMusculi.invenireSiAdest(musculiIdentitas)

        val unchanged = actuales?.nomen == nomenMusculi && actuales.descriptio == descriptioMusculi

        MinisteriumMusculi.ponere(Musculi(musculiIdentitas, nomenMusculi, descriptioMusculi))

        val responsum = if (actuales == null) {
            ConstantiaResponsumPonere.CREATED
        } else if (unchanged) {
            ConstantiaResponsumPonere.UNCHANGED
        } else {
            ConstantiaResponsumPonere.UPDATED
        }

        RenovatorRegistrorum.renova(RegistraMusculi)

        return responsum
    }

    fun delere(musculiIdentitas: MusculiIdentitas, cascade: Boolean): ConstantiaResponsumDelereRegistra {
        val configuratioMusculi = RegistraMusculiMusculiPars.omniaPerClavem(musculiIdentitas)
        val configuratioMusculiRegio =
            RegistraMusculiRegioMusculi.omnia().filter { it.musculiIdentitas == musculiIdentitas }

        if (!cascade && (configuratioMusculi.isNotEmpty() || configuratioMusculiRegio.isNotEmpty())) {
            return ConstantiaResponsumDelereRegistra.REFERENCED
        }

        if (cascade) {
            MinisteriumMusculiMusculiPars.delerePerClavem(musculiIdentitas)
            MinisteriumMusculiRegioMusculi.delerePerMusculi(musculiIdentitas)
        }

        return when (MinisteriumMusculi.delere(musculiIdentitas)) {
            1 -> {
                RenovatorRegistrorum.renova(RegistraMusculiMusculiPars)
                RenovatorRegistrorum.renova(RegistraMusculiRegioMusculi)
                RenovatorRegistrorum.renova(RegistraMusculi)
                ConstantiaResponsumDelereRegistra.SUCCESS
            }

            else -> ConstantiaResponsumDelereRegistra.NOT_FOUND
        }
    }

    fun creata(peititoMusculi: PetitioMusculi): ConstantiaResponsumCreata {
        val nomen = NomenMusculi(peititoMusculi.nomen)
        val descriptio = DescriptioMusculi(peititoMusculi.descriptio)

        return when (MinisteriumMusculi.inserta(nomen, descriptio)) {
            1 -> {
                RenovatorRegistrorum.renova(RegistraMusculi)
                ConstantiaResponsumCreata.SUCCESS
            }

            else -> ConstantiaResponsumCreata.EXISTING
        }
    }
}