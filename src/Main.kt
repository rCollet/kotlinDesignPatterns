import kotlin.properties.Delegates

fun main() {

    var address by Delegates.notNull<String>()
    address = ""
    println(address)

}








