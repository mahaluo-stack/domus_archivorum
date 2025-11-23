import org.example.commune.exceptio.registra.ExceptioRegistra

object FabricaExceptionumRegistra {

    fun clavisNonInventum(clavis: String): ExceptioRegistra =
        ExceptioRegistra(clavis)
}