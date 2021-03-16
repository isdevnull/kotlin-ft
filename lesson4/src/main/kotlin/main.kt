fun testPredicate(airportService: AirportService) = buildString {
        appendLine("Testing getAllAirportRoutesByPredicate")
        appendLine()
        airportService.getAllAirportRoutesByPredicate() { it.country == "USA" }.also { appendLine("Size = ${it.size}") }
            .forEach {
                append(it.prettyPrint())
            }
        appendLine("Finished testing getAllAirportRoutesByPredicate!")
        appendLine()
}

fun testSortedByCity(airportService: AirportService) = buildString {
    appendLine("Testing getAllAirportRoutesSortedByCity")
    appendLine()
    airportService.getAllAirportRoutesSortedByCity().forEach {
        append(it.prettyPrint())
    }
    appendLine("Finished testing getAllAirportRoutesSortedByCity!")
    appendLine()
}

fun testGroupedByCountry(airportService: AirportService) = buildString {
    appendLine("Testing getAllAirportRoutesGroupedByCountry")
    appendLine()
    airportService.getAllAirportRoutesGroupedByCountry().forEach { route ->
        appendLine(route.key)
        route.value.forEach { airport ->
            append(airport.prettyPrint())
        }
    }
    appendLine("Finished testing getAllAirportRoutesGroupedByCountry!")
    appendLine()
}

fun testCountArrivalsDepartures(airportService: AirportService) = buildString {
    appendLine("Testing testCountArrivalsDepartures")
    appendLine()

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