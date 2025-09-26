    package com.calyrsoft.ucbp1.features.profile.domain.model.vo

    @JvmInline
    value class PhoneNumber private constructor(val value: String) {
        companion object {
            fun create(raw: String): PhoneNumber {
                require(raw.isNotEmpty()) {
                    "El numero de telefono no puede estar vacio"
                }
                require(raw.length == 8) {
                    "El numero de telefono debe tener 8 digitos"
                }
                require(raw.all { it.isDigit() }) {
                    "El numero de telefono debe contener solo digitos"
                }
                require(raw.first() != '0') {
                    "El numero de telefono no puede comenzar con 0"
                }

                return PhoneNumber(raw)

            }
        }

    }