package ars_disciplina.commune.registra

import ars_disciplina.musculorum.valores.identitas.MusculiIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiParsIdentitas
import ars_disciplina.musculorum.valores.identitas.MusculiRegioIdentitas
import org.example.commune.registrum.Registra
import org.example.exemplaria.tabulae.Musculi
import org.example.exemplaria.tabulae.MusculiPars
import org.example.exemplaria.tabulae.MusculiRegio

object RegistraMusculi : Registra<MusculiIdentitas, Musculi>({ it.musculiIdentitas })
object RegistraMusculiRegio : Registra<MusculiRegioIdentitas, MusculiRegio>({ it.musculiRegioIdentitas })
object RegistraMusculiPars : Registra<MusculiParsIdentitas, MusculiPars>({ it.musculiParsIdentitas })