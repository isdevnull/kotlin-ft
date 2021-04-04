import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.*
import kotlin.random.*

class NTTests {
    private val n = 1_000_000
    private val nt = NT()
    private val primeGenerator = sequence {
        generateSequence(2L) {it + 1}
            .filter {k -> (2..floor(sqrt(k.toDouble())).toLong()).none {j -> k % j == 0L}}
            .forEach { yield(it) }
    }

    @Test
    fun `Primality Testing Edge Cases`() {
        val a = listOf(-1L, 0L, 1L, 2L, 3L)
        val b = listOf(false, false, false, true, true)
        assertEquals(a.map { nt.isPrime(it) }, b)

        val divisibleBy2 = generateSequence(4) { it + 2 }.take(n).toList()
        assertEquals(List(n) { false }, divisibleBy2.map {nt.isPrime(it.toLong())})

        val divisibleBy3 = generateSequence(6) { it + 3 }.take(n).toList()
        assertEquals(List(n) { false }, divisibleBy3.map {nt.isPrime(it.toLong())})
    }

    @Test
    fun `Primality Testing Main Cycle`() {

        assertEquals(true, nt.isPrime(5L))
        assertEquals(true, nt.isPrime(7L))

        val divisibleBy5 = generateSequence(10) { it + 5 }.take(n).toList()
        val divisibleBy7 = generateSequence(14) { it + 7 }.take(n).toList()

        assertEquals(List(n) { false }, divisibleBy5.map {nt.isPrime(it.toLong())})
        assertEquals(List(n) { false }, divisibleBy7.map {nt.isPrime(it.toLong())})


        val primes = primeGenerator.take(n).toList()

        assertEquals(List(n) {true}, primes.map{nt.isPrime(it)}) // ~ 1 min 18 sec
    }

    @Test
    fun `GCD edge case`() {
        repeat (1_000_000) {
            val x = Random(42).nextLong(1_000_000_000..3_000_000_000)
            assertEquals(x, nt.gcd(x, 0))
            assertEquals(x, nt.gcd(0, x))
        }
    }

    @Test
    fun `GCD Prime Testing`() {
        val primes = primeGenerator.take(n).toList()
        val randomNumbers = sequence {
            yield(Random(42).nextLong(1_000_000_000..3_000_000_000))
        }.take(n).toList()
        primes.zip(randomNumbers).forEach {
            assertEquals(1L, nt.gcd(it.first, it.second))
        }
    }
}