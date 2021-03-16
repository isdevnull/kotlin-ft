class AirportService(val daoAirports: DBAirports, val daoFlights: DBFlights) {

    fun getAllAirportRoutes(): List<AirportRoutes> {
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

    fun getAllAirportRoutesSortedByCity() = getAllAirportRoutes().sortedBy { it.city }

    fun getAllAirportRoutesGroupedByCountry() = getAllAirportRoutes().groupBy { it.country }

    fun getAllAirportRoutesByPredicate(predicate: (AirportRoutes) -> Boolean) = getAllAirportRoutes().filter(predicate)

    fun getCountArrivalsByAirport(iata: String): String {
        val routesByIATA = getAllAirportRoutes().find {it.iata == iata} ?: throw NoSuchElementException("There is no information about $iata airport")
        return routesByIATA.arrivals.buildSortedTable(routesByIATA.about() + '\n' + "Arrivals Count = ${routesByIATA.arrivals.size}")
    }

    fun getCountDeparturesByAirport(iata: String): String {
        val routesByIATA = getAllAirportRoutes().find {it.iata == iata} ?: throw NoSuchElementException("There is no information about $iata airport")
        return routesByIATA.departures.buildSortedTable(routesByIATA.about() + '\n' + "Departures Count = ${routesByIATA.departures.size}")
    }
}
