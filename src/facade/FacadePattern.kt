package facade

fun main() {
    val facade = Facade()
    facade.start()
    facade.doSmt()
}

class Facade {
    private lateinit var machine: Machine
    private lateinit var engine: Engine

    init {
        machine = Machine()
        engine = Engine()
    }

    fun start() {
        engine.start()
    }

    fun doSmt(){
        machine.doSmt()
    }
}

class Machine {
    fun doSmt() {
        println("do smt")
    }
}

class Engine() {
    fun start() {
        println("start")
    }
}
