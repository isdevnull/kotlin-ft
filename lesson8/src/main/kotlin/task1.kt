import kotlinx.coroutines.*

suspend fun <T> getData(inputData: Map<Int, T>): Set<T> {
    val data = mutableSetOf<T>()
    coroutineScope { // for demonstration purposes we will concurrently get data
        launch {
            for (i in 1..500) {
                val route = inputData[i]
                data.add(route!!)
            }
        }
        for (i in 501..1000) {
            val route = inputData[i]
            data.add(route!!)
        }
    }
    return data
}

fun combineData(data1: Set<RoutePrimary>, data2: Set<RouteSecondary>): List<Route> {
    return data1.map {Route(it.id, it.name, data2.find {rs -> rs.id == it.id}!!.stopsTimetable)}
}



fun main() = runBlocking<Unit> {
    val dao = DAO()
    val deferredPrimary = async { getData(dao.getAllRoutesPrimary()) }
    val deferredSecondary = async { getData(dao.getAllRoutesSecondary())}

    val routes = combineData(deferredPrimary.await(), deferredSecondary.await())
    for (i in 0 until 10) {
        println(routes[i].name)
    }
}