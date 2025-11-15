package officina.actorum.exemplaria.archivum

data class Disciplina(
    val nomen_disciplinae: String,
    val genera_disciplinae: List<String>,
    val angulus: String?,
    val variationis: String,
    val prehensiones: String,
    val genera_prehensiones: String,
    val motus: String
)
