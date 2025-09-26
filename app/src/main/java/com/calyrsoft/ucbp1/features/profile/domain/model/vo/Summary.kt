package com.calyrsoft.ucbp1.features.profile.domain.model.vo


@JvmInline
value class Summary private constructor(val value: String){
    companion object{
        fun create(raw: String): Summary {
            require(raw.isNotEmpty()){
                "El resumen no puede estar vacio"
            }
            require(raw.length >= 10){
                "El resumen debe tener al menos 10 caracteres"
            }
            return Summary(raw)
        }

    }
}