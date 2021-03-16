fun main() {
    val dbAirports = DBAirports()
    val dbFlights = DBFlights()
    val airportRoutes = AirportService().getAllAirportRoutes(dbAirports, dbFlights)

    println("Testing getAllAirportRoutesByPredicate")
    println()
    AirportService().getAllAirportRoutesByPredicate(airportRoutes) {it.country == "USA"}.also{println("Size = ${it.size}")}. forEach {
        it.prettyPrint()
        println()
    }
    println("Finished testing getAllAirportRoutesByPredicate!")
    println()

    println("Testing getAllAirportRoutesSortedByCity")
    println()
    AirportService().getAllAirportRoutesSortedByCity(airportRoutes).forEach {
        it.prettyPrint()
        println()
    }
    println("Finished testing getAllAirportRoutesSortedByCity!")
    println()

    println("Testing getAllAirportRoutesGroupedByCountry")
    println()
    AirportService().getAllAirportRoutesGroupedByCountry(airportRoutes).forEach() {
        println(it.key)
        it.value.forEach {
            elem -> elem.prettyPrint()
            println()
        }
    }
    println("Finished testing getAllAirportRoutesGroupedByCountry")
}