package client_server_data

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.SQLTimeoutException

class Client(private val url: String) {
    private val initData = InitClass().getData().associateBy { it.title }

    fun getInitData() = initData

    fun connect(): Connection = try {
        DriverManager.getConnection(url)
    } catch (ex: SQLException) {
        println(ex.message)
        throw Exception("Unable to connect to Database.")
    } catch (ex: SQLTimeoutException) {
        println(ex.message)
        throw Exception("Unable to connect due to timeout.")
    }

    fun createAndFillTables() {
        try {
            connect().use { conn ->
                initData.forEach { (_, table) ->
                    conn.createStatement().executeUpdate(table.create())
                    conn.createStatement().executeUpdate(table.fill())
                }
            }
        } catch (ex: SQLException) {
            println(ex.message)
        }
    }

    fun dropTables() {
        try {
            connect().use { conn ->
                initData.forEach { (_, table) ->
                    conn.createStatement().executeUpdate(table.drop())
                }
            }
        } catch (ex: SQLException) {
            println(ex.message)
        }
    }
}