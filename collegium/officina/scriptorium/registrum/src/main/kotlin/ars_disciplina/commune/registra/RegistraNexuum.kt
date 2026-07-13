package ars_disciplina.commune.registra

import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import ars_disciplina.nexuum.tabula.*
import org.example.commune.registrum.Registra

// disciplinarum
object RegistraDisciplinaAnguli :
    Registra<DisciplinaeIdentitas, DisciplinaAnguli>({ it.disciplinaeIdentitas })
object RegistraDisciplinaArchetypi :
        Registra<DisciplinaeIdentitas, DisciplinaArchetypi>({ it.disciplinaeIdentitas })
object RegistraDisciplinaMotus :
    Registra<DisciplinaeIdentitas, DisciplinaMotus>({ it.disciplinaeIdentitas })
object RegistraDisciplinaVariationes :
    Registra<DisciplinaeIdentitas, DisciplinaVariationes>({ it.disciplinaeIdentitas })

// classificationum
object RegistraDisciplinaGeneraDisciplinae :
    Registra<DisciplinaeIdentitas, DisciplinaGeneraDisciplinae>({ it.disciplinaeIdentitas })
object RegistraDisciplinaLateralitates :
    Registra<DisciplinaeIdentitas, DisciplinaLateralitates>({ it.disciplinaeIdentitas })
object RegistraDisciplinaModiOneris :
    Registra<DisciplinaeIdentitas, DisciplinaModiOneris>({ it.disciplinaeIdentitas })

// prehensionum
object RegistraDisciplinaGeneraPrehensionis :
    Registra<DisciplinaeIdentitas, DisciplinaGeneraPrehensionis>({ it.disciplinaeIdentitas })
object RegistraDisciplinaPrehensiones :
    Registra<DisciplinaeIdentitas, DisciplinaPrehensiones>({ it.disciplinaeIdentitas })

// regularum
object RegistraDisciplinaRegulae : Registra<DisciplinaeIdentitas, DisciplinaRegulae>({ it.disciplinaeIdentitas })

// muscululorum
object RegistraDisciplinaMusculiPars :
    Registra<DisciplinaeIdentitas, DisciplinaMusculiPars>({ it.disciplinaeIdentitas })
object RegistraMusculiMusculiPars :
    Registra<MusculiIdentitas, MusculiMusculiPars>({ it.musculiIdentitas })
object RegistraMusculiRegioMusculi :
    Registra<MusculiRegioIdentitas, MusculiRegioMusculi>({ it.musculiRegioIdentitas })


// instrumentorum
object RegistraDisciplinaInstrumenti :
    Registra<DisciplinaeIdentitas, DisciplinaInstrumenti>({ it.disciplinaeIdentitas })
object RegistraDisciplinaGeneraInstrumenti :
    Registra<DisciplinaeIdentitas, DisciplinaGeneraInstrumenti>({ it.disciplinaeIdentitas })