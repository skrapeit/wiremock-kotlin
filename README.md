wiremock-kotlin
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
