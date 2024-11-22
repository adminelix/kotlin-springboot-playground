package com.github.adminelix.kotlinspringbootplayground.letter

import com.github.adminelix.kotlinspringbootplayground.SpringBootUnitTest
import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import kotlin.test.Test

@SpringBootUnitTest
class LetterServiceTest {
    @Autowired
    lateinit var letterService: LetterService

    @Test
    fun `test something`() {
        val request: Letter =
            Letter(
                "test",
                "body",
                PostalAddress("germany", "berlin", "berlin", "12345", "hermannplatz 12"),
            )

        val response = letterService.create(request)

        assertThat(request).usingRecursiveAssertion().isEqualTo(response)
    }
}
