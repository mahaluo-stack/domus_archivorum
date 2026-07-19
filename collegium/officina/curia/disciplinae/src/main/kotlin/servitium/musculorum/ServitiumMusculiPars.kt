package servitium.musculorum

import ars_disciplina.RenovatorRegistrorum
import ars_disciplina.commune.registra.catalogus.RegistraMusculiMusculiPars
import ars_disciplina.commune.registra.catalogus.RegistraMusculiPars
import ars_disciplina.musculorum.MinisteriumMusculiPars
import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculiPars
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.nexuum.MinisteriumMusculiMusculiPars
import ars_disciplina.registrum.musculorum.RegistrumMusculiPars
import commune.constantia.ConstantiaResponsumCreata
import commune.constantia.ConstantiaResponsumDelereRegistra
import commune.constantia.ConstantiaResponsumPonere
import commune.contractus.petitio.musculorum.PetitioMusculiPars
import commune.contractus.responsa.musculorum.ResponsumMusculiPars
import org.example.exemplaria.tabulae.MusculiPars
import servitium.ServitiumLecturae
import translatores.musculorum.TranslatorMusculiPars

object ServitiumMusculiPars : ServitiumLecturae<MusculiParsIdentitas, MusculiPars, ResponsumMusculiPars>() {

    override fun omniaEntia() = RegistrumMusculiPars.omnia()
    override fun invenireEntia(identitas: MusculiParsIdentitas) = RegistrumMusculiPars.invenirePerClavemNecesse(identitas)
    override fun adResponsum(entia: MusculiPars): ResponsumMusculiPars = TranslatorMusculiPars.adResponsum(entia)

    fun invenireSiAdest(identitas: MusculiParsIdentitas): ResponsumMusculiPars? =
        RegistraMusculiPars.invenireSiAdest(identitas)?.let(::adResponsum)

    fun ponere(petitioMusculiPars: PetitioMusculiPars): ConstantiaResponsumPonere {

        val musculiParsIdentitas = MusculiParsIdentitas(petitioMusculiPars.identitas)
        val nomenMusculiPars = NomenMusculiPars(petitioMusculiPars.nomen)
        val descriptioMusculiPars = DescriptioMusculi(petitioMusculiPars.descriptio)

        val actuales = RegistrumMusculiPars.invenireSiAdest(musculiParsIdentitas)

        val unchanged = actuales?.nomen == nomenMusculiPars && actuales.descriptio == descriptioMusculiPars

        MinisteriumMusculiPars.ponere(MusculiPars(musculiParsIdentitas, nomenMusculiPars, descriptioMusculiPars))

        val responsum = if (actuales == null) {
            ConstantiaResponsumPonere.CREATED
        } else if (unchanged) {
            ConstantiaResponsumPonere.UNCHANGED
        } else {
            ConstantiaResponsumPonere.UPDATED
        }

        RenovatorRegistrorum.renova(RegistraMusculiPars)

        return responsum
    }

    fun delere(musculiParsIdentitas: MusculiParsIdentitas): ConstantiaResponsumDelereRegistra {

        MinisteriumMusculiMusculiPars.delerePerMusculiPars(musculiParsIdentitas)

        return when (MinisteriumMusculiPars.delere(musculiParsIdentitas)) {
            1 -> {
                RenovatorRegistrorum.renova(RegistraMusculiMusculiPars)
                RenovatorRegistrorum.renova(RegistraMusculiPars)
                ConstantiaResponsumDelereRegistra.SUCCESS
            }

            else -> ConstantiaResponsumDelereRegistra.NOT_FOUND
        }
    }

    fun creata(peititoMusculiPars: PetitioMusculiPars): ConstantiaResponsumCreata {
        val nomen = NomenMusculiPars(peititoMusculiPars.nomen)
        val descriptio = DescriptioMusculi(peititoMusculiPars.descriptio)

        return when (MinisteriumMusculiPars.inserta(nomen, descriptio)) {
            1 -> {
                RenovatorRegistrorum.renova(RegistraMusculiPars)
                ConstantiaResponsumCreata.SUCCESS
            }

            else -> ConstantiaResponsumCreata.EXISTING
        }
    }
}