package com.calyrsoft.ucbp1.features.github.domain.model.vo

@JvmInline

value class UrlPath(val value: String) {
    init {
        require(value.startsWith("https://"))
        {
            "El valor debe comenzar con https://"
        }

        require(value.isNotEmpty())
        {
            "El valor no puede estar vacio"
        }
    }

    override fun toString(): String = value
}