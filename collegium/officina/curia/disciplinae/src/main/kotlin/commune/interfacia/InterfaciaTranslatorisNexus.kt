package commune.interfacia

interface InterfaciaTranslatorisAggregationis<E, R> {

    fun adResponsum(entia: Collection<E>): R
}