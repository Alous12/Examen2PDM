package com.calyrsoft.ucbp1.features.profile.domain.model

import com.calyrsoft.ucbp1.features.profile.domain.model.vo.*
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertFailsWith

class ProfileModelTest {
    @Test
    fun `crea ProfileModel válido`() {
        val m = ProfileModel(
            name = Name.create("Mateo"),
            email = Email.create("mateo@example.com"),
            pathUrl = PathUrl.create("https://example.com/a.png"),
            cellphone = PhoneNumber.create("71234567"),
            summary = Summary.create("Estudiante de Ing. de Sistemas en UCB.")
        )
        assertNotNull(m)
    }


}
