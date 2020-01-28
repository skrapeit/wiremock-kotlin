package it.skrape

class MappingScope {

    val url = UrlPatternScope()
    var willReturn = ResponseScope()

    fun willReturn(fn: ResponseScope.() -> Unit) {
        this.willReturn = ResponseScope().apply(fn)
    }
}
