package com.calyrsoft.ucbp1.features.profile.domain.model.vo

@JvmInline
value class Name private constructor(val value: String) {
    companion object{
        fun create(raw: String): Name {
            require(raw.isNotEmpty()){
                "El nombre no puede ser vacio"
            }
            require(raw.length >= 3){
                "El Nombre no debe tener menos de 3 letras"
            }
            require(raw.length <= 30){
                "El nombre no debe ser mas largo que 30 caracteres"
            }
            require(raw.first().isUpperCase()){
                "El nombre debe comenzar con mayuscula"
            }
            require(raw.all {it.isLetter()})
            return Name(raw)
        }

    }
}