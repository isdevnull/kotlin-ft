data class AirportRoutes(
    val iata: String,
    val name: String,
    val city: String,
    val country: String,
    val arrivals: List<Flight>,
    val departures: List<Flight>
)

fun AirportRoutes.about() = "$iata, $name, $city, $country"

fun AirportRoutes.prettyPrint() = buildString {
    appendLine(about())

    appendLine("Arrivals")
    appendLine(arrivals.buildSortedTable())

    appendLine("Departures")
    appendLine(departures.buildSortedTable())
}