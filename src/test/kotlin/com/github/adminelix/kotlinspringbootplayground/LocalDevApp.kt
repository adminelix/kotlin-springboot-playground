package com.github.adminelix.kotlinspringbootplayground

import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<App>().with(TestcontainersConfiguration::class).run(*args)
}
