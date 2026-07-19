package servitium.musculorum

import ars_disciplina.RenovatorRegistrorum
import ars_disciplina.commune.registra.catalogus.RegistraMusculiRegio
import ars_disciplina.commune.registra.catalogus.RegistraMusculiRegioMusculi
import ars_disciplina.musculorum.MinisteriumMusculiRegio
import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculiRegio
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import ars_disciplina.nexuum.MinisteriumMusculiRegioMusculi
import ars_disciplina.registrum.musculorum.RegistrumMusculiRegio
import commune.constantia.ConstantiaResponsumCreata
import commune.constantia.ConstantiaResponsumDelereRegistra
import commune.constantia.ConstantiaResponsumPonere
import commune.contractus.petitio.musculorum.PetitioMusculiRegio
import commune.contractus.responsa.musculorum.ResponsumMusculiRegio
import org.example.exemplaria.tabulae.MusculiRegio
import servitium.ServitiumLecturae
import translatores.musculorum.TranslatorMusculiRegio

object ServitiumMusculiRegio : ServitiumLecturae<MusculiRegioIdentitas, MusculiRegio, ResponsumMusculiRegio>() {

    override fun omniaEntia() = RegistrumMusculiRegio.omnia()
    override fun invenireEntia(identitas: MusculiRegioIdentitas) = RegistrumMusculiRegio.invenirePerClavemNecesse(identitas)
    override fun adResponsum(entia: MusculiRegio): ResponsumMusculiRegio = TranslatorMusculiRegio.adResponsum(entia)

    fun invenireSiAdest(identitas: MusculiRegioIdentitas): ResponsumMusculiRegio? =
        RegistraMusculiRegio.invenireSiAdest(identitas)?.let(::adResponsum)

    fun ponere(petitioMusculiRegio: PetitioMusculiRegio): ConstantiaResponsumPonere {

        val musculiRegioIdentitas = MusculiRegioIdentitas(petitioMusculiRegio.identitas)
        val nomenMusculiRegio = NomenMusculiRegio(petitioMusculiRegio.nomen)
        val descriptioMusculiRegio = DescriptioMusculi(petitioMusculiRegio.descriptio)

        val actuales = RegistrumMusculiRegio.invenireSiAdest(musculiRegioIdentitas)

        val unchanged = actuales?.nomen == nomenMusculiRegio && actuales.descriptio == descriptioMusculiRegio

        MinisteriumMusculiRegio.ponere(MusculiRegio(musculiRegioIdentitas, nomenMusculiRegio, descriptioMusculiRegio))

        val responsum = if (actuales == null) {
            ConstantiaResponsumPonere.CREATED
        } else if (unchanged) {
            ConstantiaResponsumPonere.UNCHANGED
        } else {
            ConstantiaResponsumPonere.UPDATED
        }

        RenovatorRegistrorum.renova(RegistraMusculiRegio)

        return responsum
    }

    fun delere(musculiRegioIdentitas: MusculiRegioIdentitas, cascade: Boolean): ConstantiaResponsumDelereRegistra {
        val configuratioMusculiRegio = RegistraMusculiRegioMusculi.omniaPerClavem(musculiRegioIdentitas)

        if (!cascade && configuratioMusculiRegio.isNotEmpty()) {
            return ConstantiaResponsumDelereRegistra.REFERENCED
        }

        if (cascade) {
            MinisteriumMusculiRegioMusculi.delerePerClavem(musculiRegioIdentitas)
        }

        return when (MinisteriumMusculiRegio.delere(musculiRegioIdentitas)) {
            1 -> {
                RenovatorRegistrorum.renova(RegistraMusculiRegioMusculi)
                RenovatorRegistrorum.renova(RegistraMusculiRegio)
                ConstantiaResponsumDelereRegistra.SUCCESS
            }

            else -> ConstantiaResponsumDelereRegistra.NOT_FOUND
        }
    }

    fun creata(peititoMusculiRegio: PetitioMusculiRegio): ConstantiaResponsumCreata {
        val nomen = NomenMusculiRegio(peititoMusculiRegio.nomen)
        val descriptio = DescriptioMusculi(peititoMusculiRegio.descriptio)

        return when (MinisteriumMusculiRegio.inserta(nomen, descriptio)) {
            1 -> {
                RenovatorRegistrorum.renova(RegistraMusculiRegio)
                ConstantiaResponsumCreata.SUCCESS
            }

            else -> ConstantiaResponsumCreata.EXISTING
        }
    }
}