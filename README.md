wiremock-kotlin [![CI build status](https://github.com/skrapeit/wiremock-kotlin/workflows/CI/badge.svg)](https://github.com/skrapeit/wiremock-kotlin/actions?query=workflow%3ACI)
===============

Create WireMock stubs via Kotlin DSL 

## Example

```kotlin
data class Song(val title: String)

stubFor {
    get {
        url equalTo "/my-api"
        willReturn {

            headers = mapOf("Content-Type" to "application/json")

            body jsonFromObject Song("The revenge of Vera Gemini")
        }
    }
}
```
