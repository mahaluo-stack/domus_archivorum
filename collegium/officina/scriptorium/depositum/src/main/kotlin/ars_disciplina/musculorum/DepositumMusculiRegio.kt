package ars_disciplina.musculorum

import ars_disciplina.Depositum
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_DESCRIPTIO
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MUSCULI_REGIO_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_NOMEN_MUSCULI_REGIO
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_MUSCULORUM
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_MUSCULI_REGIO
import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculiRegio
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import org.example.exemplaria.tabulae.MusculiRegio
import java.sql.ResultSet

object DepositumMusculiRegio : Depositum<MusculiRegio>() {
    override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_MUSCULORUM"
    override val nomenTabulae = NOMEN_TABULAE_MUSCULI_REGIO
    override fun crea(rs: ResultSet): MusculiRegio {
        return MusculiRegio(
            MusculiRegioIdentitas(rs.getInt(NOMEN_COLUMNAE_MUSCULI_REGIO_IDENTITAS)),
            NomenMusculiRegio(rs.getString(NOMEN_COLUMNAE_NOMEN_MUSCULI_REGIO)),
            DescriptioMusculi(rs.getString(NOMEN_COLUMNAE_DESCRIPTIO) ?: "")
        )
    }
}