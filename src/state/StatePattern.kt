package state

fun main() {
    val gateImpl: GateImpl = GateImpl()
    val idleState: GateState = ClosedGateState(gateImpl)
    gateImpl.state = idleState

    gateImpl.enter()

    gateImpl.pay()
    gateImpl.pay()
    gateImpl.enter()
    gateImpl.enter()
}

interface Gate {
    var state: GateState
}

class GateImpl: Gate {
    override lateinit var state: GateState

    fun enter() {
        state.enter()
    }
    fun pay() {
        state.pay()
    }
}

interface GateState {
    fun enter()
    fun pay()
}

class OpenGateState(private val gate: Gate): GateState {
    override fun enter() {
        println("Enter succeed - GateImpl is now closed.")
        gate.state = ClosedGateState(gate)
    }

    override fun pay() {
        println("Pay failed - GateImpl is already open.")
    }
}

class ClosedGateState(private val gate: Gate): GateState {
    override fun enter() {
        println("Enter failed - GateImpl is closed.")
    }

    override fun pay() {
        println("Pay - GateImpl is open.")
        gate.state = OpenGateState(gate)
    }
}