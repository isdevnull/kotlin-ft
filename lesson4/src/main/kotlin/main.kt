fun testPredicate(airportService: AirportService) = buildString {
        appendLine("Testing getAllAirportRoutesByPredicate\n")
        airportService.getAllAirportRoutesByPredicate() { it.country == "USA" }.also { appendLine("Size = ${it.size}") }
            .forEach {
                append(it.prettyPrint())
            }
        appendLine("Finished testing getAllAirportRoutesByPredicate!\n")
}

fun testSortedByCity(airportService: AirportService) = buildString {
    appendLine("Testing getAllAirportRoutesSortedByCity\n")
    airportService.getAllAirportRoutesSortedByCity().forEach {
        append(it.prettyPrint())
    }
    appendLine("Finished testing getAllAirportRoutesSortedByCity!\n")
}

fun testGroupedByCountry(airportService: AirportService) = buildString {
    appendLine("Testing getAllAirportRoutesGroupedByCountry\n")
    airportService.getAllAirportRoutesGroupedByCountry().forEach { route ->
        appendLine(route.key)
        route.value.forEach { airport ->
            append(airport.prettyPrint())
        }
    }
    appendLine("Finished testing getAllAirportRoutesGroupedByCountry!\n")
}

fun testCountArrivalsDepartures(airportService: AirportService) = buildString {
    appendLine("Testing testCountArrivalsDepartures\n")

    appendLine(airportService.getCountArrivalsByAirport("MAD"))
    appendLine(airportService.getCountDeparturesByAirport("SFO"))

    appendLine("Finished testing testCountArrivalsDepartures!")
}

fun main() {
    val airportService = AirportService(DBAirports(), DBFlights())
    val output = buildString {
        append(testPredicate(airportService))
        append(testSortedByCity(airportService))
        append(testGroupedByCountry(airportService))
        append(testCountArrivalsDepartures(airportService))
    }
    print(output)
}