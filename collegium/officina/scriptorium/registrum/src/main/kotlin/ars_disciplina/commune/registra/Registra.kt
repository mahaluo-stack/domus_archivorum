package org.example.commune.registrum

import FabricaExceptionumRegistra.clavisNonInventum
import ars_disciplina.commune.registra.InterfaciaRegistri

open class Registra<K, T>(
    private val selectorClavis: (T) -> K
) : InterfaciaRegistri<T> {
    private val perClavem = mutableMapOf<K, T>()

    override fun initializa(res: Collection<T>) {
        perClavem.clear()
        res.forEach { perClavem[selectorClavis(it)] = it }
    }

    fun invenirePerClavemNecesse(clavis: K): T = perClavem[clavis]
        ?: throw clavisNonInventum("Clavis: '${clavis}' non inventa in registro.")

    fun continet(clavis: K): Boolean =
        perClavem.containsKey(clavis)

    fun invenireSiAdest(clavis: K): T? = perClavem[clavis]

    fun omniaPerClaves(claves: Set<K>): Set<T> = claves.mapTo(mutableSetOf()) { invenirePerClavemNecesse(it) }

    fun omnia(): Collection<T> = perClavem.values
}