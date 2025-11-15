package org.example.commune.registrum

open class Registra<K, T>(
    private val keySelector: (T) -> K
) {
    private val perClavem = mutableMapOf<K, T>()

    fun initializa(items: Collection<T>) {
        perClavem.clear()
        items.forEach { perClavem[keySelector(it)] = it }
    }

    fun invenirePerClavem(key: K): T? = perClavem[key]

    fun items(): Collection<T> = perClavem.values
}