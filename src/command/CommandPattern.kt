package command

fun main() {
    val remoteInvoker = RemoteInvoker()
    val bigLightReceiver: LightReceiver = BigLightReceiver()
    val smallLightReceiver: LightReceiver = SmallLightReceiver()

    val bigLightCommand: Command = LightCommand(bigLightReceiver)
    val smallLightCommand: Command = LightCommand(smallLightReceiver)

    remoteInvoker.setCommandButton1(bigLightCommand)
    remoteInvoker.setCommandButton2(smallLightCommand)

    remoteInvoker.click1()
    remoteInvoker.click2()
}

class RemoteInvoker {
    private lateinit var command1: Command
    private lateinit var command2: Command

    fun setCommandButton1(command: Command) {
        this.command1 = command
    }
    fun setCommandButton2(command: Command) {
        this.command2 = command
    }

    fun click1() {
        command1.execute()
    }
    fun click2() {
        command2.execute()
    }
}

interface Command {
    fun execute()
}

class LightCommand(private val receiver: LightReceiver) : Command {
    override fun execute() {
        receiver.toggle()
    }
}

interface LightReceiver {
    fun toggle()
}

class BigLightReceiver : LightReceiver {
    override fun toggle() {
        println("big light is toggle")
    }
}
class SmallLightReceiver : LightReceiver {
    override fun toggle() {
        println("small light is toggle")
    }
}