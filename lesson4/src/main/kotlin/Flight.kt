import java.time.LocalTime

data class Flight(val airport: Airport, val time: LocalTime)

fun Flight.printInfo() = "${time}, ${airport.iata}, ${airport.name}, ${airport.city}, ${airport.country}"

fun List<Flight>.buildSortedTable(additionalInfo: String="") = buildString {
    if (additionalInfo != "") appendLine(additionalInfo)
    sortedBy { it.time }.forEach {
        appendLine(it.printInfo())
    }
}