package com.github.adminelix.kotlinspringbootplayground.letter

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/v1/letter")
class LetterController(val letterService: LetterService) {
    @PostMapping
    fun create(
        @RequestBody letter: Letter,
    ): ResponseEntity<Letter> {
        return ResponseEntity.created(URI("/foobar")).body(letterService.create(letter))
    }
}
