package client_server_data

interface Table {
    val title: String
    val createStmt: String
    val fillStmt: String
    fun create() = createStmt
    fun fill() = fillStmt
    fun drop() = "DROP TABLE IF EXISTS $title;"
}