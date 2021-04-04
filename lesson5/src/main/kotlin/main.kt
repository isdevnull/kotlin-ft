import client_server_data.Server

fun main() {
    val server = Server("jdbc:sqlite:src/main/resources/MusicDataBase")
    server.client.dropTables()
    server.client.createAndFillTables()
    server.findItemByID("Artists", 1)
    server.findAlbumByPredicateYear(2008)
    server.countByRole()
    server.client.dropTables()
}