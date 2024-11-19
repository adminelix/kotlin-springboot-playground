package com.github.adminelix.kotlinspringbootplayground.letter

data class PostalAddress(
    val country: String,
    val locality: String,
    val region: String,
    val postalCode: String,
    val streetAddress: String,
)
