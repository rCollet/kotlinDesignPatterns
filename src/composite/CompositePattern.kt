package composite

fun main() {
    val todo1: Todo = SingleTodo("1")
    val todo2: Todo = SingleTodo("2")
    val todo3: Todo = SingleTodo("3")
    val todo4: Todo = SingleTodo("4")
    val todo5: Todo = SingleTodo("5")
    val todo6: Todo = SingleTodo("6")
    val todo7: Todo = SingleTodo("7")
    val todo8: Todo = TodoStep("8", listOf(todo2, todo3))
    val todo9: Todo = TodoStep("9", listOf(todo7))
    val todo10: Todo = TodoStep("10", listOf(todo8, todo1))
    val todo11: Todo = TodoStep("11", listOf(todo10, todo4))

    val todos = listOf(todo11, todo9, todo5, todo6)
    for (todo in todos) {
        print(todo.toHtml())
    }
}

interface Todo {
    val label: String
    fun toHtml(): String
}

class SingleTodo(override val label: String) : Todo {
    override fun toHtml(): String {
        return "<li>$label</li>"
    }
}

class TodoStep(override val label: String, private val steps: List<Todo>) : Todo {
    override fun toHtml(): String {
        var res = "<ul><li>"
        res += "$label"
        res += "<ul>"
        for (step in steps) {
            res += step.toHtml()
        }
        res += "</ul></li></ul>"
        return res
    }
}