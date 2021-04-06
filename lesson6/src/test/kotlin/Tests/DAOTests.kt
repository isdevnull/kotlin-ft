package Tests

import DAO
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifyOrder
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DAOTests {

    @Test
    fun `DAO test`() {
        // setup data
        val dao = mockk<DAO> {
           every {data} returns listOf(1,2,3,4).map {it to "$it"}.toMap()
        }

        // mockk
        for (i in 1 until 5) {
            every { dao.getItemById(i) } returns "$i"
        }
        for (i in 5..10) {
            every {dao.getItemById(i)} returns null
        }
        every {dao.getAllItems()} returns listOf("1", "2", "3", "4")


        val resultsById = mutableListOf<String?>()
        for (i in 1..10) {
            resultsById.add(dao.getItemById(i))
        }

        val allItems = dao.getAllItems()

        verifyOrder {
            for (i in 1..10) {
                dao.getItemById(i)
            }
            dao.getAllItems()
        }

        assertAll("Testing Dao",
            { assertEquals(4, dao.data.size)},
            { assertEquals(listOf("1", "2", "3", "4", null, null, null, null, null, null), resultsById)},
            { assertEquals(listOf("1", "2", "3", "4"), allItems) }
        )

    }
}