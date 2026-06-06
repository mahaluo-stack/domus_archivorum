package ars_disciplina.registrum

abstract class Registrum<I, T> {
    abstract fun omnia(): Collection<T>
    abstract fun invenire(identitas: I): T
}