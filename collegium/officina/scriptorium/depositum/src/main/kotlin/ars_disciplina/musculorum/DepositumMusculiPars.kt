package ars_disciplina.musculorum

import ars_disciplina.DepositumTabulae
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_DESCRIPTIO
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MUSCULI_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MUSCULI_PARS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_NOMEN_MUSCULI_PARS
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_MUSCULORUM
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_MUSCULI_PARS
import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculiPars
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import org.example.exemplaria.tabulae.MusculiPars
import java.sql.ResultSet

object DepositumMusculiPars : DepositumTabulae<MusculiPars>() {
    override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_MUSCULORUM"
    override val nomenTabulae = NOMEN_TABULAE_MUSCULI_PARS
    override fun crea(rs: ResultSet): MusculiPars {
        return MusculiPars(
            MusculiParsIdentitas(rs.getInt(NOMEN_COLUMNAE_MUSCULI_PARS_IDENTITAS)),
            MusculiIdentitas(rs.getInt(NOMEN_COLUMNAE_MUSCULI_IDENTITAS)),
            NomenMusculiPars(rs.getString(NOMEN_COLUMNAE_NOMEN_MUSCULI_PARS)),
            DescriptioMusculi(rs.getString(NOMEN_COLUMNAE_DESCRIPTIO) ?: "")
        )
    }
}