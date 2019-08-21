package strategy

fun main() {
    val cityDuck = Duck(SimpleQuackBehaviorImpl(), SimpleFlyBehaviorImpl())
    cityDuck.quack()
    cityDuck.fly()
    val wildDuck = Duck(SpecialQuackBehaviorImpl(), SimpleFlyBehaviorImpl())
    wildDuck.quack()
}

class Duck(private val quackBehavior: QuackBehavior, private val flyBehavior: FlyBehavior) {
    fun quack() = quackBehavior.quack()
    fun fly() = flyBehavior.fly()
}

interface QuackBehavior {
    fun quack()
}

class SimpleQuackBehaviorImpl : QuackBehavior {
    override fun quack() {
        println("Simple quack!")
    }
}

class SpecialQuackBehaviorImpl : QuackBehavior {
    override fun quack() {
        println("Special quack quack!")
    }
}

interface FlyBehavior {
    fun fly()
}

class SimpleFlyBehaviorImpl(): FlyBehavior {
    override fun fly() {
        println("flying...")
    }
}

