package fr.reivon.kotkot

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 *
 * @author Tony MEMBOT
 * @since 07/05/2018
 */
class MyTestCase {

    private val egg = Ingredient("Oeuf", 4)

    @Test
    fun `ensure ingredient with quantity 4 which add 1 give 5`() {
        val result = egg + 1
        assertEquals(5, result.quantity)
        assertEquals("Oeuf", result.name)
        assertEquals("", result.measureUnit)
    }

}