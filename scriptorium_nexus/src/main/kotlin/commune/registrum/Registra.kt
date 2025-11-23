package org.example.commune.registrum

import FabricaExceptionumRegistra.clavisNonInventum

open class Registra<K, T>(
    private val selectorClavis: (T) -> K
) {
    private val perClavem = mutableMapOf<K, T>()

    fun initializa(items: Collection<T>) {
        perClavem.clear()
        items.forEach { perClavem[selectorClavis(it)] = it }
    }

    fun invenirePerClavemNecesse(clavis: K): T = perClavem[clavis]
        ?: throw clavisNonInventum("Clavis: '${clavis}' non inventa in registro.")

    fun items(): Collection<T> = perClavem.values
}