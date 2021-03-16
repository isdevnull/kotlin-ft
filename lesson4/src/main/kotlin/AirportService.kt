class AirportService {

    fun getAllAirportRoutes(daoAirports: DBAirports, daoFlights: DBFlights): List<AirportRoutes> {
        val airports = daoAirports.getAirportsInfo().sortedBy { it.iata }
        val flights = airports.map {
            daoFlights.getFlightsByIATA(it.iata)
        }
        return airports.zip(flights) {
                airport, flight ->
            AirportRoutes(
                airport.iata,
                airport.name,
                airport.city,
                airport.country,
                flight.arrivals,
                flight.departures
            )
        }
    }

    fun getAllAirportRoutesSortedByCity(airportRoutes: List<AirportRoutes>) = airportRoutes.sortedBy { it.city }

    fun getAllAirportRoutesGroupedByCountry(airportRoutes: List<AirportRoutes>) = airportRoutes.groupBy { it.country }

    fun getAllAirportRoutesByPredicate(airportRoutes: List<AirportRoutes>, predicate: (AirportRoutes) -> Boolean) = airportRoutes.filter(predicate)

}