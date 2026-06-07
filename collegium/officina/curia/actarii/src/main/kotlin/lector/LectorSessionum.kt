package officina.actorum.lector

import officina.actorum.exemplaria.scriptura.SessioBruta
import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.api.rename
import org.jetbrains.kotlinx.dataframe.api.toListOf
import org.jetbrains.kotlinx.dataframe.io.readCSV

object LectorSessionum {
    fun lege(viaMateria: String): List<SessioBruta> {
        val materia = object {}.javaClass.getResource(viaMateria)
            ?: throw IllegalArgumentException("Resource not found")
        return DataFrame.readCSV(materia)
            .rename("id" to "identitas", "body" to "corpus", "date" to "dies", "exercises" to "exercitia")
            .toListOf()
    }
}