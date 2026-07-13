package servitium

abstract class ServitiumLecturaeNexuum<I, E, R> {

    protected abstract fun omniaEntia(): Collection<E>

    protected abstract fun adResponsum(entia: Set<E>): R

    abstract fun omnia(): Collection<R>

    protected abstract fun omniaPerClavem(identitas: I): Collection<R>
}