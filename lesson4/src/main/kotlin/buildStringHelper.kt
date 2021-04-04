import kotlin.text.StringBuilder

fun buildString(build: StringBuilder.() -> Unit): String {
    val stringBuilder = StringBuilder()
    stringBuilder.build()
    return stringBuilder.toString()
}