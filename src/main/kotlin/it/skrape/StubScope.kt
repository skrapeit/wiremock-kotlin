package it.skrape

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.WireMock

@WireMockDsl
class StubScope {

    val builders = mutableListOf<MappingBuilder>()

    fun get(init: MappingScope.() -> Unit) {

        addNewMapping("GET", init)
    }

    fun post(init: MappingScope.() -> Unit) {

        addNewMapping("POST", init)
    }

    fun put(init: MappingScope.() -> Unit) {

        addNewMapping("PUT", init)
    }

    fun delete(init: MappingScope.() -> Unit) {

        addNewMapping("DELETE", init)
    }

    fun patch(init: MappingScope.() -> Unit) {

        addNewMapping("PATCH", init)
    }

    fun options(init: MappingScope.() -> Unit) {

        addNewMapping("OPTIONS", init)
    }

    fun head(init: MappingScope.() -> Unit) {

        addNewMapping("HEAD", init)
    }

    fun trace(init: MappingScope.() -> Unit) {

        addNewMapping("TRACE", init)
    }

    fun any(init: MappingScope.() -> Unit) {

        addNewMapping("ANY", init)
    }

    private fun addNewMapping(method: String, init: MappingScope.() -> Unit) {

        val scope = MappingScope()
        scope.init()

        builders.add(buildRealWireMockMapping(method, scope))
    }

    private fun buildRealWireMockMapping(method: String,
                                         scope: MappingScope): MappingBuilder {

        return WireMock
                .request(method, scope.url.pattern)
                .willReturn(scope.willReturn.builder)
    }
}
