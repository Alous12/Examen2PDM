package com.calyrsoft.ucbp1.features.profile.domain.model.vo

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class PhoneNumberTest {
    @Test
    fun `crea phone válido`() {
        val p = PhoneNumber.create("71234567")
        assertEquals("71234567", p.value)
    }

    @Test
    fun `falla si vacío`() {
        assertFailsWith<IllegalArgumentException> { PhoneNumber.create("") }
    }

    @Test
    fun `falla si longitud distinta de 8`() {
        assertFailsWith<IllegalArgumentException> { PhoneNumber.create("1234567") }
        assertFailsWith<IllegalArgumentException> { PhoneNumber.create("123456789") }
    }

    @Test
    fun `falla si no dígitos`() {
        assertFailsWith<IllegalArgumentException> { PhoneNumber.create("1234abcd") }
    }

    @Test
    fun `falla si empieza en 0`() {
        assertFailsWith<IllegalArgumentException> { PhoneNumber.create("01234567") }
    }
}
