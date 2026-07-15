package ars_disciplina.commune.registra

import FabricaExceptionumRegistra.clavisNonInventum

abstract class RegistraNexuum<K, T>(
    private val selectorClavis: (T) -> K
) : InterfaciaRegistri<T> {

    private val perClavem = mutableMapOf<K, MutableSet<T>>()

    override fun initializa(res: Collection<T>) {

        perClavem.clear()

        res.forEach {
            perClavem.getOrPut(selectorClavis(it)) { mutableSetOf() }.add(it)
        }
    }

    fun omniaPerClavem(clavis: K): Set<T> = perClavem[clavis] ?: emptySet()

    fun omnia(): Collection<T> = perClavem.values.flatten()

    fun omniaPerClavemNecesse(clavis: K): Set<T> = omniaPerClavem(clavis)
        .takeIf { it.isNotEmpty() }
        ?: throw clavisNonInventum(
            "Clavis: '$clavis' non inventa in registro."
        )
}