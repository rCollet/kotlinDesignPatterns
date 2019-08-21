package decorator

fun main() {
    val cappuccino: Beverage = Caramel(SoyMilk(Cappuccino()))
    println("Products: ${cappuccino.getDescription()}")
    println("Total price: ${cappuccino.getCost()}")

    val mocca: Beverage = Caramel(Mocca())
    println("Products: ${mocca.getDescription()}")
    println("Total price: ${mocca.getCost()}")
}

interface Beverage {
    fun getDescription(): String
    fun getCost(): Int
}

class Cappuccino: Beverage {
    override fun getDescription() = "Cappuccino"

    override fun getCost(): Int = 3
}
class Mocca: Beverage {
    override fun getDescription() = "Mocca"

    override fun getCost(): Int = 2
}

interface ToppingDecorator: Beverage {
    val beverage: Beverage
}

class SoyMilk(override val beverage: Beverage): ToppingDecorator {
    override fun getDescription(): String {
        return "${beverage.getDescription()}, Soy Milk"
    }

    override fun getCost(): Int {
        return beverage.getCost() + 1
    }
}

class Caramel(override val beverage: Beverage): ToppingDecorator {
    override fun getDescription(): String {
        return "${beverage.getDescription()}, Caramel"
    }

    override fun getCost(): Int {
        return beverage.getCost() + 2
    }
}