package ars_disciplina.musculorum

import ars_disciplina.Depositum
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_DESCRIPTIO
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MUSCULI_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_MUSCULI_REGIO_IDENTITAS
import ars_disciplina.commune.constantia.ConstantiaNomenColumnae.NOMEN_COLUMNAE_NOMEN_MUSCULI
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_ARCHIVUM_ARS_DISCIPLINA
import ars_disciplina.commune.constantia.ConstantiaNomenSchemata.NOMEN_SCHEMATA_MUSCULORUM
import ars_disciplina.commune.constantia.ConstantiaNomenTabulae.NOMEN_TABULAE_MUSCULI
import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculi
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import org.example.exemplaria.tabulae.Musculi
import java.sql.ResultSet

object DepositumMusculi : Depositum<Musculi>() {
    override val nomenSchemata = "$NOMEN_ARCHIVUM_ARS_DISCIPLINA.$NOMEN_SCHEMATA_MUSCULORUM"
    override val nomenTabulae = NOMEN_TABULAE_MUSCULI
    override fun crea(rs: ResultSet): Musculi {
        return Musculi(
            MusculiIdentitas(rs.getInt(NOMEN_COLUMNAE_MUSCULI_IDENTITAS)),
            MusculiRegioIdentitas(rs.getInt(NOMEN_COLUMNAE_MUSCULI_REGIO_IDENTITAS)),
            NomenMusculi(rs.getString(NOMEN_COLUMNAE_NOMEN_MUSCULI)),
            DescriptioMusculi(rs.getString(NOMEN_COLUMNAE_DESCRIPTIO) ?: "")
        )
    }
}