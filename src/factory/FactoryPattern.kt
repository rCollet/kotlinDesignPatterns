package factory

import java.util.*

fun main() {
    val animalFactory: AnimalFactory = RandomAnimalFactory()
    val animal1 = animalFactory.create()
    val animal2 = animalFactory.create()
    val animal3 = animalFactory.create()
    val animal4 = animalFactory.create()

    println(animal1.name)
    println(animal2.name)
    println(animal3.name)
    println(animal4.name)
}

interface Animal {
    val name: String
}

class Cat : Animal {
    override val name: String = "Cat"
}
class Dog : Animal {
    override val name: String = "Dog"
}

interface AnimalFactory {
    fun create(): Animal
}

class RandomAnimalFactory: AnimalFactory {
    override fun create(): Animal {
        val randomBoolean = Random().nextBoolean()
        return if(randomBoolean) Cat() else Dog()
    }
}