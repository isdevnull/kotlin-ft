import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import kotlin.math.*
import kotlin.random.*

class ExtensionTests {

    private val n = 1_000_000
    private val primeGenerator = sequence {
        generateSequence(3L) {it + 1}
            .filter {k -> (2..floor(sqrt(k.toDouble())).toLong()).none { j -> k % j == 0L}}
            .forEach { yield(it) }
    }

    @Test
    fun `Exception Test`() {
        val randomNumbers = sequence {
            yield(Random(42).nextLong(1_000_000_000..3_000_000_000))
        }.take(n).toList()
        randomNumbers.forEach {
            k ->
            val ex1 = assertThrows(Exception::class.java) {k.findFiniteInverse(-5L)}
            val ex2 = assertThrows(Exception::class.java) {k.findFiniteInverse(0L)}
            assertEquals("Modulo should be positive.", ex1.message)
            assertEquals("Modulo should be positive.", ex2.message)


        }
        val divisibleBy2 = generateSequence(4) { it + 2 }.take(n).toList()
        divisibleBy2.forEach {
            k ->
            val ex3 = assertThrows(Exception::class.java) {100L.findFiniteInverse(k.toLong())}
            assertEquals("There is no inverse for 100 in Z/${k}Z Ring.", ex3.message)
        }
    }

    @Test
    fun `Test Inverses`() {
        val primeIterator = primeGenerator.iterator() // inv always exists for prime quotient
        repeat (10000) {
            val x = Random(42).nextLong(1L..1_000_000)
            val y = primeIterator.next()
            if (NT().gcd(x, y) == 1L) {
                assertEquals(1L, (x * x.findFiniteInverse(y) % y))
            }
        }
    }
}