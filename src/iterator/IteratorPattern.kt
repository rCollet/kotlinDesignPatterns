package iterator

fun main() {
    val inventory = Inventory()
    val iterator = inventory.iterable

    while(iterator.hasNext()) {
        println(iterator.next())
    }
}

interface Container<T> {
    val iterable: Iterable<T>
}

interface Iterable<T> {
    fun next(): T
    fun hasNext(): Boolean
}

class Inventory : Container<String> {
    val items: List<String> = listOf("Knife", "Sword", "Shield", "Arrow")
    override val iterable: Iterable<String> by lazy { InventoryIterator(this) }
}

class InventoryIterator(private val inventory: Inventory) : Iterable<String> {

    private var index: Int = 0

    override fun next(): String {
        return inventory.items.get(index++)
    }

    override fun hasNext(): Boolean {
        return inventory.items.size > index
    }
}