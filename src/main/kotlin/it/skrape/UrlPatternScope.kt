package it.skrape

import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.matching.UrlPattern

@WireMockDsl
class UrlPatternScope {

    lateinit var pattern: UrlPattern

    infix fun equalTo(str: String) {
        pattern = WireMock.urlEqualTo(str)
    }

    infix fun matching(str: String) {
        pattern = WireMock.urlMatching(str)
    }
}
