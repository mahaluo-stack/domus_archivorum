package ars_disciplina.nexuum

import ars_disciplina.Depositum
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MUSCULI_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MUSCULI_PARS_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MUSCULI_REGIO_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_NEXUUM
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_MUSCULI_MUSCULI_REGIO
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_MUSCULI_PARS_MUSCULI
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import ars_disciplina.nexuum.tabula.MusculiMusculiRegio
import ars_disciplina.nexuum.tabula.MusculiParsMusculi
import java.sql.ResultSet

object DepositumMusculiMusculiRegio : Depositum<MusculiMusculiRegio>() {
    override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_NEXUUM"
    override val nomenTabulae = NOMEN_TABULAE_MUSCULI_MUSCULI_REGIO

    override fun crea(rs: ResultSet): MusculiMusculiRegio {
        return MusculiMusculiRegio(
            MusculiIdentitas(rs.getInt(NOMEN_COLUMNAE_MUSCULI_IDENTITAS)),
            MusculiRegioIdentitas(rs.getInt(NOMEN_COLUMNAE_MUSCULI_REGIO_IDENTITAS)),
        )
    }
}