package `null`

fun main() {
    val customerFactory: CustomerFactory = CustomerFactoryImpl()

    val customer1 = customerFactory.create("Bob")
    println(customer1.name)
    customer1.doAction()

    val customer2 = customerFactory.create("Yiyi")
    println(customer2.name)
    customer2.doAction()

    val customer3 = customerFactory.create("Bill")
    println(customer3.name)
    customer3.doAction()
}

interface Customer {
    val name: String
    fun doAction()
}

class RealCustomer(override val name: String) : Customer {
    override fun doAction() {
        println("Do some action.")
    }
}

class NullCustomer: Customer {
    override val name: String = "No name available."

    override fun doAction() {
        println("No action available.")
    }
}

interface CustomerFactory {
    fun create(name: String): Customer
}

class CustomerFactoryImpl: CustomerFactory {
    val namesReference = listOf("Bob", "Joe", "Yiyi")
    override fun create(name: String): Customer {
        if(namesReference.any {it.toLowerCase() == name.toLowerCase()}) {
            return RealCustomer(name)
        } else return NullCustomer()
    }
}