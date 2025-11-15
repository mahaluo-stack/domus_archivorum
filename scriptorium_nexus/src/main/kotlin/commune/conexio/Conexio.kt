package org.example.commune.conexio

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import java.sql.Connection

object Conexio {

    private val dataSource: HikariDataSource

    init {
        val config = HikariConfig().apply {
            jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=ars_disciplina"
            driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"

            // Integrated security / trusted connection
            addDataSourceProperty("authenticationScheme", "nativeAuthentication")
            addDataSourceProperty("integratedSecurity", "true")
            addDataSourceProperty("encrypt", "true")
            addDataSourceProperty("trustServerCertificate", "true")

            // Hikari settings
            maximumPoolSize = 10
            minimumIdle = 2
            idleTimeout = 30000
            connectionTimeout = 30000
            maxLifetime = 1800000
        }

        dataSource = HikariDataSource(config)
    }

    fun getConnection(): Connection {
        return dataSource.connection
    }
}