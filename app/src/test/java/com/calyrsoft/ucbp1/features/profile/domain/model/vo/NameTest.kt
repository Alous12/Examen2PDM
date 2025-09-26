package com.calyrsoft.ucbp1.features.profile.domain.model.vo

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class NameTest {
    @Test
    fun `crea nombre válido`() {
        val n = Name.create("Mateo")
        assertEquals("Mateo", n.value)
    }

    @Test
    fun `falla si vacío`() {
        assertFailsWith<IllegalArgumentException> { Name.create("") }
    }

    @Test
    fun `falla si menor a 3`() {
        assertFailsWith<IllegalArgumentException> { Name.create("Al") }
    }

    @Test
    fun `falla si mayor a 30`() {
        assertFailsWith<IllegalArgumentException> { Name.create("A".repeat(31)) }
    }

    @Test
    fun `falla si no inicia en mayúscula`() {
        assertFailsWith<IllegalArgumentException> { Name.create("mateo") }
    }

    @Test
    fun `falla si contiene no-letras`() {
        assertFailsWith<IllegalArgumentException> { Name.create("Mateo1") }
    }
}
