package org.example.instrumentorum.regulae

import ars_disciplina.instrumentorum.valores.NomenInstrumenti
import org.example.commune.regulae.RegulaTribunal

fun regulaInstrumenta(
    tribunal: RegulaTribunal,
    nomen: String,
    block: RegulaInstrumenta.() -> Unit
) {
    RegulaInstrumenta(tribunal, NomenInstrumenti(nomen)).apply(block)
}

@DslMarker
annotation class RegulaInstrumentaDsl

@RegulaInstrumentaDsl
class RegulaInstrumenta(
    tribunal: RegulaTribunal,
    nomen: NomenInstrumenti
) {

}