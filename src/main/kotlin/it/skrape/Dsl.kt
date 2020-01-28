package it.skrape

import com.github.tomakehurst.wiremock.client.WireMock

@WireMockDsl
fun stubFor(init: StubScope.() -> Unit) {

    val stubScope = StubScope().apply(init)

    stubScope.builders.forEach { WireMock.stubFor(it) }
}

@DslMarker
annotation class WireMockDsl