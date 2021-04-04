import java.time.LocalTime

class DBAirports {
    val iataDB = hashSetOf<Airport>(
        Airport("JFK", "John F. Kennedy International Airport", "New York City", "USA"),
        Airport("LAX", "Los Angeles International Airport", "Los Angeles", "USA"),
        Airport("SFO", "San Francisco International Airport", "San Francisco", "USA"),
        Airport("MAD", "Adolfo Suárez Madrid–Barajas Airport", "Madrid", "Spain"),
        Airport("SVO", "Sheremetyevo International Airport", "Moscow", "Russia"),
        Airport("CDG", "Charles de Gaulle Airport", "Paris", "France")
    )

    fun getAirportsInfo() = iataDB
}

class DBFlights {
    private val airportsByIATA = DBAirports().iataDB.associateBy {it.iata}
    val flightsDB = hashSetOf<AirportFlights>(
        AirportFlights("JFK",
            listOf<Flight>(
                Flight(airportsByIATA["LAX"]!!, LocalTime.of(10, 15, 30)),
                Flight(airportsByIATA["SFO"]!!, LocalTime.of(11, 10, 20)),
                Flight(airportsByIATA["MAD"]!!, LocalTime.of(12, 44, 10)),
                Flight(airportsByIATA["SVO"]!!, LocalTime.of(15, 13, 1)),
                Flight(airportsByIATA["CDG"]!!, LocalTime.of(19, 34, 46))
            ),
            listOf<Flight>(
                Flight(airportsByIATA["LAX"]!!, LocalTime.of(11, 15, 30)),
                Flight(airportsByIATA["SFO"]!!, LocalTime.of(12, 10, 20)),
                Flight(airportsByIATA["MAD"]!!, LocalTime.of(13, 44, 10)),
                Flight(airportsByIATA["SVO"]!!, LocalTime.of(16, 13, 1)),
                Flight(airportsByIATA["CDG"]!!, LocalTime.of(20, 34, 46))
            )
        ),
        AirportFlights("LAX",
            listOf<Flight>(
                Flight(airportsByIATA["JFK"]!!, LocalTime.of(18, 15, 30)),
                Flight(airportsByIATA["SFO"]!!, LocalTime.of(13, 32, 20)),
                Flight(airportsByIATA["MAD"]!!, LocalTime.of(18, 23, 10)),
                Flight(airportsByIATA["SVO"]!!, LocalTime.of(6, 48, 1)),
                Flight(airportsByIATA["CDG"]!!, LocalTime.of(22, 33, 59))
            ),
            listOf<Flight>(
                Flight(airportsByIATA["JFK"]!!, LocalTime.of(19, 15, 30)),
                Flight(airportsByIATA["SFO"]!!, LocalTime.of(13, 32, 20)),
                Flight(airportsByIATA["MAD"]!!, LocalTime.of(19, 44, 10)),
                Flight(airportsByIATA["SVO"]!!, LocalTime.of(7, 13, 1)),
                Flight(airportsByIATA["CDG"]!!, LocalTime.of(22, 34, 46))
            )
        ),
        AirportFlights("SFO",
            listOf<Flight>(
                Flight(airportsByIATA["JFK"]!!, LocalTime.of(20, 15, 30)),
                Flight(airportsByIATA["LAX"]!!, LocalTime.of(5, 15, 30)),
                Flight(airportsByIATA["MAD"]!!, LocalTime.of(3, 23, 10)),
                Flight(airportsByIATA["SVO"]!!, LocalTime.of(1, 48, 1)),
                Flight(airportsByIATA["CDG"]!!, LocalTime.of(9, 33, 59))
            ),
            listOf<Flight>(
                Flight(airportsByIATA["JFK"]!!, LocalTime.of(21, 15, 30)),
                Flight(airportsByIATA["LAX"]!!, LocalTime.of(6, 15, 30)),
                Flight(airportsByIATA["MAD"]!!, LocalTime.of(4, 44, 10)),
                Flight(airportsByIATA["SVO"]!!, LocalTime.of(2, 13, 1)),
                Flight(airportsByIATA["CDG"]!!, LocalTime.of(10, 34, 46))
            )
        ),
        AirportFlights("MAD",
            listOf<Flight>(
                Flight(airportsByIATA["JFK"]!!, LocalTime.of(15, 3, 30)),
                Flight(airportsByIATA["LAX"]!!, LocalTime.of(10, 6, 30)),
                Flight(airportsByIATA["SFO"]!!, LocalTime.of(4, 30, 20)),
                Flight(airportsByIATA["SVO"]!!, LocalTime.of(11, 43, 1)),
                Flight(airportsByIATA["CDG"]!!, LocalTime.of(18, 33, 59))
            ),
            listOf<Flight>(
                Flight(airportsByIATA["JFK"]!!, LocalTime.of(16, 15, 30)),
                Flight(airportsByIATA["LAX"]!!, LocalTime.of(11, 15, 30)),
                Flight(airportsByIATA["SFO"]!!, LocalTime.of(5, 32, 20)),
                Flight(airportsByIATA["SVO"]!!, LocalTime.of(12, 13, 1)),
                Flight(airportsByIATA["CDG"]!!, LocalTime.of(19, 34, 46))
            )
        ),
        AirportFlights("SVO",
            listOf<Flight>(
                Flight(airportsByIATA["JFK"]!!, LocalTime.of(22, 2, 10)),
                Flight(airportsByIATA["LAX"]!!, LocalTime.of(3, 47, 30)),
                Flight(airportsByIATA["SFO"]!!, LocalTime.of(20, 12, 20)),
                Flight(airportsByIATA["MAD"]!!, LocalTime.of(13, 42, 10)),
                Flight(airportsByIATA["CDG"]!!, LocalTime.of(23, 33, 59))
            ),
            listOf<Flight>(
                Flight(airportsByIATA["JFK"]!!, LocalTime.of(23, 15, 30)),
                Flight(airportsByIATA["LAX"]!!, LocalTime.of(4, 15, 30)),
                Flight(airportsByIATA["SFO"]!!, LocalTime.of(21, 32, 20)),
                Flight(airportsByIATA["MAD"]!!, LocalTime.of(14, 44, 10)),
                Flight(airportsByIATA["CDG"]!!, LocalTime.of(0, 34, 46))
            )
        ),
        AirportFlights("CDG",
            listOf<Flight>(
                Flight(airportsByIATA["JFK"]!!, LocalTime.of(3, 2, 10)),
                Flight(airportsByIATA["LAX"]!!, LocalTime.of(22, 47, 30)),
                Flight(airportsByIATA["SFO"]!!, LocalTime.of(10, 12, 20)),
                Flight(airportsByIATA["SVO"]!!, LocalTime.of(6, 13, 1)),
                Flight(airportsByIATA["MAD"]!!, LocalTime.of(5, 42, 10)),
            ),
            listOf<Flight>(
                Flight(airportsByIATA["JFK"]!!, LocalTime.of(4, 15, 30)),
                Flight(airportsByIATA["LAX"]!!, LocalTime.of(23, 15, 30)),
                Flight(airportsByIATA["SFO"]!!, LocalTime.of(11, 32, 20)),
                Flight(airportsByIATA["SVO"]!!, LocalTime.of(7, 13, 1)),
                Flight(airportsByIATA["MAD"]!!, LocalTime.of(6, 44, 10)),
            )
        ),
    )

    fun getFlightInfo() = flightsDB

    fun getFlightsByIATA(iata: String): AirportFlights {
        return flightsDB.find {it.iataCode == iata} ?: throw NoSuchElementException("There is no information about $iata airport")
    }
}