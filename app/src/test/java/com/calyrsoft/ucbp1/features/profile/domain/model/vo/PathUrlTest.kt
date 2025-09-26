package com.calyrsoft.ucbp1.features.profile.domain.model.vo

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class PathUrlTest {
    @Test
    fun `crea url válida`() {
        val u = PathUrl.create("https://example.com/avatar.png")
        assertEquals("https://example.com/avatar.png", u.value)
    }

    @Test
    fun `falla si no https`() {
        assertFailsWith<IllegalArgumentException> { PathUrl.create("http://example.com") }
    }

    @Test
    fun `falla si vacío`() {
        assertFailsWith<IllegalArgumentException> { PathUrl.create("") }
    }
}
