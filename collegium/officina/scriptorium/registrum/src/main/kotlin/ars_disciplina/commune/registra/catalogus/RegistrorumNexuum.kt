package ars_disciplina.commune.registra.catalogus

import ars_disciplina.commune.registra.RegistraNexuum
import ars_disciplina.disciplinarum.valores.identitas.DisciplinaeIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import ars_disciplina.nexuum.tabula.*
import org.example.commune.registrum.Registra

// disciplinarum
object RegistraDisciplinaAnguli :
    RegistraNexuum<DisciplinaeIdentitas, DisciplinaAnguli>({ it.disciplinaeIdentitas })

object RegistraDisciplinaArchetypi :
    RegistraNexuum<DisciplinaeIdentitas, DisciplinaArchetypi>({ it.disciplinaeIdentitas })

object RegistraDisciplinaMotus :
    Registra<DisciplinaeIdentitas, DisciplinaMotus>({ it.disciplinaeIdentitas })

object RegistraDisciplinaVariationes :
    RegistraNexuum<DisciplinaeIdentitas, DisciplinaVariationes>({ it.disciplinaeIdentitas })

// classificationum
object RegistraDisciplinaGeneraDisciplinae :
    Registra<DisciplinaeIdentitas, DisciplinaGeneraDisciplinae>({ it.disciplinaeIdentitas })

object RegistraDisciplinaLateralitates :
    RegistraNexuum<DisciplinaeIdentitas, DisciplinaLateralitates>({ it.disciplinaeIdentitas })

object RegistraDisciplinaModiOneris :
    RegistraNexuum<DisciplinaeIdentitas, DisciplinaModiOneris>({ it.disciplinaeIdentitas })

// prehensionum
object RegistraDisciplinaGeneraPrehensionis :
    RegistraNexuum<DisciplinaeIdentitas, DisciplinaGeneraPrehensionis>({ it.disciplinaeIdentitas })

object RegistraDisciplinaPrehensiones :
    RegistraNexuum<DisciplinaeIdentitas, DisciplinaPrehensiones>({ it.disciplinaeIdentitas })

// regularum
object RegistraDisciplinaRegulae : RegistraNexuum<DisciplinaeIdentitas, DisciplinaRegulae>({ it.disciplinaeIdentitas })

// muscululorum
object RegistraDisciplinaMusculiPars :
    RegistraNexuum<DisciplinaeIdentitas, DisciplinaMusculiPars>({ it.disciplinaeIdentitas })

object RegistraMusculiMusculiPars :
    RegistraNexuum<MusculiIdentitas, MusculiMusculiPars>({ it.musculiIdentitas })

object RegistraMusculiRegioMusculi :
    RegistraNexuum<MusculiRegioIdentitas, MusculiRegioMusculi>({ it.musculiRegioIdentitas })


// instrumentorum
object RegistraDisciplinaInstrumenti :
    RegistraNexuum<DisciplinaeIdentitas, DisciplinaInstrumenti>({ it.disciplinaeIdentitas })

object RegistraDisciplinaGeneraInstrumenti :
    RegistraNexuum<DisciplinaeIdentitas, DisciplinaGeneraInstrumenti>({ it.disciplinaeIdentitas })