import java.time.LocalTime
import kotlin.random.Random

data class Coordinates(val latitude: Double, val longitude: Double)
data class Stop(val id: Int, val coordinates: Coordinates)
data class RoutePrimary(val id: Int, val name: String)
data class RouteSecondary(val id: Int, val stopsTimetable: Map<Stop, LocalTime>)
data class Route(val id: Int, val name: String, val stopsTimetable: Map<Stop, LocalTime>)

class Generator(private val seed: Int) {
    private val randomBase = Random(seed)

    fun getRandomCoordinates(): Coordinates {
        val lat = randomBase.nextDouble(-90.0, 90.0)
        val long = randomBase.nextDouble(-180.0, 180.0)
        return Coordinates(lat, long)
    }

    fun getRandomTime(): LocalTime {
        val hour = randomBase.nextInt(0, 23)
        val minute = randomBase.nextInt(0, 60)
        return LocalTime.of(hour, minute)
    }

    fun getRandomRouteName(): String {
        val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val letter = alphabet.random(randomBase)
        val no = randomBase.nextInt(1, 999)
        return letter + "$no"
    }

}

class DAO {
    private val gen = Generator(42)
    private val nRoutes: Int = 1_000
    private val nStops: Int = 5_000

    private val allRoutesPrimary: Map<Int, RoutePrimary> = (1..nRoutes).map {
            i -> i to RoutePrimary(i, gen.getRandomRouteName())
    }.toMap()
    private val allRoutesSecondary: Map<Int, RouteSecondary> = (1..nRoutes).map {
        i ->
        i to RouteSecondary(i, (1..nStops)
            .map {k -> Stop(k, gen.getRandomCoordinates())}
            .map {stop -> stop to gen.getRandomTime()}.toMap()
        )
    }.toMap()

    fun getAllRoutesPrimary() = allRoutesPrimary
    fun getAllRoutesSecondary() = allRoutesSecondary
}