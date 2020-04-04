package jp.denx.exitus

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.*
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.withCharset
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.serialization.json
import org.slf4j.event.Level

val ContentType.Companion.Utf8Json
    get() = ContentType.Application.Json.withCharset(Charsets.UTF_8)

fun Application.module() {
    install(DefaultHeaders)
    install(CallLogging) {
        level = Level.INFO
    }
    install(ContentNegotiation) {
        json()
    }
    install(CORS) {
        method(HttpMethod.Options)
        anyHost()
        headers.addAll(listOf("authorization", "crossdomain", "x-csrf-token", "X-2222AccessToken"))
        allowCredentials = true
        allowNonSimpleContentTypes = true
        exposeHeader("*")
    }
    install(StatusPages) {
        status(HttpStatusCode.NotFound) {
            call.respondText("404", status = HttpStatusCode.NotFound)
        }
        exception<ContentTransformationException> {
            call.respondText(contentType = ContentType.Utf8Json, status = HttpStatusCode.BadRequest) { """{"error":"wrong request body"}""" }
        }
    }
    install(Routing) {
        get("/") {
            context.respondText { "Hello, World!" }
        }
    }
}