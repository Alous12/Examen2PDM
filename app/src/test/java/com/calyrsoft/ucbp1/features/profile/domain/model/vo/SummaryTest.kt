package com.calyrsoft.ucbp1.features.profile.domain.model.vo

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SummaryTest {
    @Test
    fun `crea summary válido`() {
        val s = Summary.create("Desarrollador Android con Compose.")
        assertEquals("Desarrollador Android con Compose.", s.value)
    }

    @Test
    fun `falla si vacío`() {
        assertFailsWith<IllegalArgumentException> { Summary.create("") }
    }

    @Test
    fun `falla si menor a 10 chars`() {
        assertFailsWith<IllegalArgumentException> { Summary.create("Muy corto") }
    }
}
