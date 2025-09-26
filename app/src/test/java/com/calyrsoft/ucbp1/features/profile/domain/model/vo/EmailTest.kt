package com.calyrsoft.ucbp1.features.profile.domain.model.vo

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.test.assertFailsWith


class EmailTest {
    @Test
    fun `crea email válido`() {
        val email = Email.create("John.Doe@Example.COM ")
        assertEquals("john.doe@example.com", email.value)
    }

    @Test
    fun `falla si vacío`() {
        assertFailsWith<IllegalArgumentException> { Email.create("") }
    }

    @Test
    fun `falla si no contiene arroba`() {
        assertFailsWith<IllegalArgumentException> { Email.create("john.example.com") }
    }

    @Test
    fun `falla si no termina en com`() {
        assertFailsWith<IllegalArgumentException> { Email.create("john@example.org") }
    }
}