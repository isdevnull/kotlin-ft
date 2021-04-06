package Tests

import BatchNorm2D
import Conv2D
import Model
import ReLU
import io.mockk.mockk
import io.mockk.every
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ModelDSLTests {

    @Test
    fun `Mockk Test`() {
        val model = mockk<Model> {
            every {name} returns "Sample Model"
            every {layers} returns mutableListOf(
                mockk<Conv2D> {
                    every {name} returns "Conv2D"
                    every {in_channels} returns 1
                    every {out_channels} returns 128
                },
                mockk<Conv2D> {
                    every {name } returns "Conv2D"
                    every {in_channels} returns 128
                    every {out_channels} returns 256
                },
                mockk<BatchNorm2D> {
                    every {name} returns "BN"
                    every { channels } returns 256
                },
                mockk<ReLU> {
                    every { name } returns "ReLU"
                }
            )
        }


        assertAll("Test Model",
            { assertEquals(4, model.layers.size) },
            { assertEquals("Sample Model", model.name) }
        )

    }
}