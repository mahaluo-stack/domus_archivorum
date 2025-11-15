package officina.actorum.exemplaria.scriptura

data class Sessio(
    val id: String,
    val dies: String,
    val exercitia: List<Exercitium>
)