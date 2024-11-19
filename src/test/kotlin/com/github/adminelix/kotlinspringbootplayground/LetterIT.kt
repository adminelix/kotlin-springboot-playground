package com.github.adminelix.kotlinspringbootplayground

import com.github.adminelix.kotlinspringbootplayground.letter.Letter
import com.github.adminelix.kotlinspringbootplayground.letter.PostalAddress
import io.restassured.http.ContentType
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.context.annotation.Import

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestcontainersConfiguration::class)
class LetterIT {
    @LocalServerPort
    private var port: Int = 0

    @Test
    fun `test something`() {
        val request: Letter =
            Letter(
                "test",
                "body",
                PostalAddress("germany", "berlin", "berlin", "12345", "hermannplatz 12"),
            )

        val response: Letter =
            Given {
                port(port)
                contentType(ContentType.JSON)
                body(request)
            } When {
                post("/v1/letter")
            } Then {
                statusCode(201)
                body("subject", equalTo(request.subject))
            } Extract {
                `as`(Letter::class.java)
            }

        assertThat(request).usingRecursiveAssertion().isEqualTo(response)
    }
}
