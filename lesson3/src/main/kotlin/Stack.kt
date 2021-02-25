import java.lang.Exception
import java.util.LinkedList

class CustomStack<T> {
    private val container = LinkedList<T>()
    var size: Int = 0
        private set

    fun push(t: T) = container.add(t).also { size++ }
    fun pop(): T {
        size--
        val res:T
        if (container.size > 0)
            res = container.last().also { container.removeLast() }
        else
            throw Exception("Stack is empty.")
        return res
    }
}

fun <T> stackOf(vararg elements: T): CustomStack<T> {
    val s = CustomStack<T>()
    elements.asList().forEach {s.push(it)}
    return s
}

fun <T> CustomStack<T>.isEmpty(): Boolean = this.size == 0