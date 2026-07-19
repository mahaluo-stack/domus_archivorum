package ars_disciplina.registrum

abstract class Registrum<I, T> {
    abstract fun omnia(): Collection<T>
    abstract fun invenirePerClavemNecesse(identitas: I): T
    abstract fun invenireSiAdest(identitas: I): T?
}