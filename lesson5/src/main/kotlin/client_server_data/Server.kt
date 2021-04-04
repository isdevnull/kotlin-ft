package client_server_data

import java.sql.SQLException
import Album
import info

class Server(url: String) {
    internal val client = Client()

    fun findItemByID(tableTitle: String, id: Int) {
        val sqlQuery: String = """
            SELECT * FROM $tableTitle
            WHERE ID = ?
            """.trimIndent()
        try {
            client.connect().use {
                conn ->
                conn.prepareStatement(sqlQuery).use {
                    stmt ->
                    stmt.setInt(1, id)
                    val resultSet = stmt.executeQuery()
                    while (resultSet.next()) {
                        println(resultSet.getString(2))
                    }
                }
            }
        }
        catch (ex: SQLException) {
            println(ex.message)
        }
    }

    fun findAlbumByPredicateYear(year: Int) {
        val sqlQuery = """
            SELECT ALB.ID, A.Name, ALB.AlbumTitle, ALB.Year FROM Albums ALB
            LEFT JOIN Artists A on ALB.ArtistID = A.ID
            WHERE Alb.Year < ?;
        """.trimIndent()
        try {
            client.connect().use {
                conn ->
                conn.prepareStatement(sqlQuery).use {
                    stmt ->
                    stmt.setInt(1, year)
                    val resultSet = stmt.executeQuery()
                    val albumsByPredicate = mutableListOf<Album>()
                    while (resultSet.next()) {
                        val albId = resultSet.getInt(1)
                        val songs = mutableListOf<String>()
                        val querySongsByAlbID = """
                            SELECT SongTitle FROM SONGS
                            WHERE AlbumID = ?
                            ORDER BY Position
                        """.trimIndent()
                        conn.prepareStatement(querySongsByAlbID).use {
                            stmtSongs ->
                            stmtSongs.setInt(1, albId)
                            val resultSongs = stmtSongs.executeQuery()
                            while (resultSongs.next()) {
                                songs.add(resultSongs.getString(1))
                            }
                        }
                        val artist = resultSet.getString(2)
                        val albTitle = resultSet.getString(3)
                        val releaseYear = resultSet.getInt(4)
                        albumsByPredicate.add(Album(albTitle, songs, artist, releaseYear))
                    }
                    val sb = StringBuilder()
                    albumsByPredicate.forEach {sb.append("${it.info()}\n")}
                    println(sb.toString())
                }
            }
        } catch (ex: SQLException) {
            println(ex.message)
        }
    }

    fun countByRole() {
        val sqlQuery = """
                SELECT  R.Role, COUNT(M.ID) AS No_of_members FROM Members as M
                LEFT OUTER JOIN MembersAndRoles MAR on M.ID = MAR.MemberID
                LEFT OUTER JOIN Roles R on MAR.RoleID = R.ID
                GROUP BY R.Role
                ORDER BY No_of_members DESC;
            """.trimIndent()
        try {
            client.connect().use {
                    conn ->
                conn.createStatement().use {
                        stmt ->
                    val results = stmt.executeQuery(sqlQuery)
                    val roleCount = mutableListOf<Pair<String, Int>>()
                    while (results.next()) {
                        val role = results.getString(1)
                        val cnt = results.getInt(2)
                        roleCount.add(Pair(role, cnt))
                    }
                    val s = roleCount.joinToString(separator = "\n") { p -> "${p.first}: ${p.second} people" }
                    println("Roles – Count")
                    println(s)
                }
            }
        } catch (ex: SQLException) {
            println(ex.message)
        }
    }
}