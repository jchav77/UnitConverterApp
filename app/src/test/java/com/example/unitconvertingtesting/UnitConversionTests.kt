package com.example.unitconvertingtesting

import org.junit.Assert.assertEquals
import org.junit.Test

class UnitConversionTests {

    @Test
    fun testCelsiusToFahrenheit() {
        val celsius = 0.0
        val expectedFahrenheit = "32.0 °F"
        assertEquals(expectedFahrenheit, convertTemperature(celsius))
    }

    @Test
    fun testMetersToFeet() {
        val meters = 1.0
        val expectedFeet = "3.28084 ft"
        assertEquals(expectedFeet, convertLength(meters))
    }
}