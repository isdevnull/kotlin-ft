data class Airport(val iata: String, val name: String, val city: String, val country: String)

data class AirportFlights(
    val iataCode: String,
    val arrivals: List<Flight>,
    val departures: List<Flight>
)
