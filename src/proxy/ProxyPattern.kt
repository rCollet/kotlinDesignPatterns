package proxy

fun main() {
    val connector: LoginConnector = LoginConnectorProxy()
    connector.login()
}

interface LoginConnector {
    fun login()
}

class LoginConnectorProxy() : LoginConnector {

    override fun login() {
        val enoughSecure = true
        if (enoughSecure) LoginConnectorImpl().login()
    }
}

class LoginConnectorImpl : LoginConnector {
    override fun login() {
        println("log")
    }
}
