package officina.actorum.exemplaria.archivum

import ars_disciplina.musculorum.valores.DescriptioMusculi
import ars_disciplina.musculorum.valores.NomenMusculi
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import org.example.exemplaria.tabulae.Musculi
import org.example.exemplaria.tabulae.MusculiPars
import org.example.exemplaria.tabulae.MusculiRegio

class EntiaMusculi (
    val musculiIdentitas: MusculiIdentitas,
    val nomenMusculi: NomenMusculi,
    val descriptioMusculi: DescriptioMusculi,
    val musculiRegio: MusculiRegio,
    val musculiPars: Set<MusculiPars>
)