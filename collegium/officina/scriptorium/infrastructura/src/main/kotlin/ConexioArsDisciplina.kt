import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

object ConexioArsDisciplina {

    private val dataSource: HikariDataSource

    init {
        val config = HikariConfig().apply {
            jdbcUrl = System.getenv("DB_URL")
            username = System.getenv("DB_USERNAME")
            password = System.getenv("DB_PASSWORD")

            driverClassName = "org.postgresql.Driver"

            maximumPoolSize = 10
            minimumIdle = 2
            idleTimeout = 30000
            connectionTimeout = 30000
            maxLifetime = 1800000
        }

        dataSource = HikariDataSource(config)
    }

    private fun legeConexio(): Connection {
        return dataSource.connection
    }

    private fun exsequere(
        scriptum: String,
        parametri: PreparedStatement.() -> Unit = {}
    ): Int {
        legeConexio().use { conexio ->
            conexio.prepareStatement(scriptum).use { ps ->
                ps.parametri()
                return ps.executeUpdate()
            }
        }
    }

    private fun <T> interroga(
        scriptum: String,
        parametri: PreparedStatement.() -> Unit = {},
        structor: (ResultSet) -> T
    ): T {
        legeConexio().use { conexio ->
            conexio.prepareStatement(scriptum).use { ps ->
                ps.parametri()

                ps.executeQuery().use { rs ->
                    return structor(rs)
                }
            }
        }
    }

    fun <T> legeOmnes(
        scriptum: String,
        parametri: PreparedStatement.() -> Unit = {},
        structor: (ResultSet) -> T
    ): Set<T> = interroga(scriptum, parametri) { rs ->
        val collectio = mutableSetOf<T>()
        while (rs.next()) {
            collectio.add(
                structor(rs)
            )
        }
        collectio
    }

    fun renova(
        scriptum: String,
        parametri: PreparedStatement.() -> Unit = {}
    ): Int = exsequere(scriptum, parametri)

    fun dele(
        scriptum: String,
        parametri: PreparedStatement.() -> Unit = {}
    ): Int = exsequere(scriptum, parametri)

    fun inserta(
        scriptum: String,
        parametri: PreparedStatement.() -> Unit = {}
    ): Int = interroga(scriptum, parametri) { rs ->
        rs.next()
        rs.getInt(1)
    }
}