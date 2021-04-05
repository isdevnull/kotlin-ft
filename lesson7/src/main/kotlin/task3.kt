import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureNanoTime

fun main() {
    val pools = listOf(10, 20, 30).map {it to Executors.newFixedThreadPool(it)}.toMap()
    val n = 1_000_000
    val results = pools.map {
            (nPools, pool) ->
        val cnt = AtomicInteger(0)
        nPools to measureNanoTime {
            for (i in 1..n) {
                pool.submit(cnt::incrementAndGet)
            }
            pool.shutdown()
            pool.awaitTermination(60, TimeUnit.SECONDS)
            pool.shutdownNow()
        }.also {check(cnt.get() == n)}

    }
    results.sortedBy { it.second }.forEach {
        println("Pool with ${it.first} threads has elapsed time: ${it.second}")
    }
}
