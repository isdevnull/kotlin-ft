data class Album(
    val name: String,
    val trackList: List<String>,
    val artist: String,
    val year: Int
)

fun Album.info(): String {
    val sb = StringBuilder()
    sb.append("'$name' was released by $artist in $year.\n")
    sb.append("Track List:\n")
    sb.append(
        IntArray(trackList.size) { n -> n + 1 }
            .zip(trackList)
            .joinToString(separator = "\n") { p -> "${p.first}. ${p.second}" }
    )
    sb.appendLine()
    return sb.toString()
}