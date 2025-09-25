package com.calyrsoft.ucbp1.features.github.domain.model.vo

@JvmInline
value class NickName(val value: String) {
    init {
        require(value.isNotEmpty())
        {
            "El valor no puede estar vacio"
        }
        require(!value.startsWith(" "))
        {
            "El valor no puede comenzar con espacios"
        }
        require(!value.endsWith(" "))
        {
            "El valor no puede terminar con espacios"
        }
        require(value.length >= 3)
        {
            "El valor debe tener al menos 3 caracteres"
        }
    }
    override fun toString(): String = value
}