package servitium

abstract class ServitiumLecturae<I, E, R> {

    protected abstract fun omniaEntia(): Collection<E>

    protected abstract fun invenireEntia(identitas: I): E

    protected abstract fun adResponsum(entia: E): R

    fun omnia(): Collection<R> = omniaEntia().map(::adResponsum)

    fun invenire(identitas: I): R = adResponsum(invenireEntia(identitas))

    fun omniaPerClavem(identitas: I): Collection<R> = omniaEntia().map(::adResponsum)
}