package com.calyrsoft.ucbp1.features.profile.domain.model.vo

@JvmInline

value class PathUrl private constructor(val value: String) {
    companion object {
        fun create(raw: String): PathUrl {
            require(raw.startsWith("https://"))
            {
                "El valor debe comenzar con https://"
            }

            require(raw.isNotEmpty())
            {
                "El valor no puede estar vacio"
            }
            return PathUrl(raw)
        }
    }

}