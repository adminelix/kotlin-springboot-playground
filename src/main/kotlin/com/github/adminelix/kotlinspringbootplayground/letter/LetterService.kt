package com.github.adminelix.kotlinspringbootplayground.letter

import org.springframework.stereotype.Service

@Service
class LetterService {
    fun create(letter: Letter): Letter {
        return letter
    }
}
