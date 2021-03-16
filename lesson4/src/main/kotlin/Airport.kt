import java.time.LocalTime

data class Airport(val iata: String, val name: String, val city: String, val country: String)

data class AirportFlights(
    val iataCode: String,
    val arrivals: HashMap<Airport, LocalTime>,
    val departures: HashMap<Airport, LocalTime>
)

data class AirportRoutes(
    val iata: String,
    val name: String,
    val city: String,
    val country: String,
    val arrivals: HashMap<Airport, LocalTime>,
    val departures: HashMap<Airport, LocalTime>
)

fun HashMap<Airport, LocalTime>.printSortedTable() {
    toList().sortedBy { it.second }.forEach {
        println("${it.second}, ${it.first.iata}, ${it.first.name}, ${it.first.city}, ${it.first.country}")
    }
}

fun AirportRoutes.prettyPrint() {
    println("$iata, $name, $city, $country")

    println("Arrivals")
    arrivals.printSortedTable()

    println("Departures")
    departures.printSortedTable()
}
