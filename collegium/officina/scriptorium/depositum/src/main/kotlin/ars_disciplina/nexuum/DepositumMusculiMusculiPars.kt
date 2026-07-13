package ars_disciplina.nexuum

import ars_disciplina.Depositum
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MUSCULI_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MUSCULI_PARS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_NEXUUM
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_MUSCULI_MUSCULI_PARS
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.nexuum.tabula.MusculiMusculiPars
import java.sql.ResultSet

object DepositumMusculiMusculiPars : Depositum<MusculiMusculiPars>() {
    override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_NEXUUM"
    override val nomenTabulae = NOMEN_TABULAE_MUSCULI_MUSCULI_PARS

    override fun crea(rs: ResultSet): MusculiMusculiPars {
        return MusculiMusculiPars(
            MusculiIdentitas(rs.getInt(NOMEN_COLUMNAE_MUSCULI_IDENTITAS)),
            MusculiParsIdentitas(rs.getInt(NOMEN_COLUMNAE_MUSCULI_PARS_IDENTITAS)),
        )
    }
}