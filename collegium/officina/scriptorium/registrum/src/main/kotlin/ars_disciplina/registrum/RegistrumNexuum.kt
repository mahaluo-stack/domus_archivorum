package ars_disciplina.registrum

abstract class RegistrumNexuum<I, T> {
    abstract fun omnia(): Collection<T>
    abstract fun omniaPerClavem(identitas: I): Collection<T>
}