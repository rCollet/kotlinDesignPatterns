package adapter

fun main() {
    val adaptee = Adaptee()
    val adapter: IAdapter = Adapter(adaptee)

    adapter.request()
}

interface IAdapter {
    fun request()
}

class Adapter(private val adaptee: Adaptee): IAdapter {
    override fun request() {
        adaptee.specificRequest()
    }

}

class Adaptee {
    fun specificRequest() {
        println("Special request")
    }
}
