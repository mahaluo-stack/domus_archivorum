package org.example.commune.registrum

import FabricaExceptionumRegistra.clavisNonInventum

open class Registra<K, T>(
    private val selectorClavis: (T) -> K
) {
    private val perClavem = mutableMapOf<K, T>()

    fun initializa(res: Collection<T>) {
        perClavem.clear()
        res.forEach { perClavem[selectorClavis(it)] = it }
    }

    fun invenirePerClavemNecesse(clavis: K): T = perClavem[clavis]
        ?: throw clavisNonInventum("Clavis: '${clavis}' non inventa in registro.")

    fun omniaPerClavemNecesse(clavis: K): Set<T> = omniaPerClavem(clavis)
        .takeIf { it.isNotEmpty() }
        ?: throw clavisNonInventum(
            "Clavis: '$clavis' non inventa in registro."
        )

    fun invenirePerClavem(clavis: K): T? =
        perClavem[clavis]

    fun continet(clavis: K): Boolean =
        perClavem.containsKey(clavis)

    fun omniaPerClaves(claves: Set<K>): Set<T> = claves.mapTo(mutableSetOf()) { invenirePerClavemNecesse(it) }
    fun omniaPerClavem(clavis: K): Set<T> = invenirePerClavem(clavis)?.let(::setOf) ?: emptySet()

    fun omnia(): Collection<T> = perClavem.values
}