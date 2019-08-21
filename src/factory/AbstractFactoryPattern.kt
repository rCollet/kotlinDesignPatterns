package factory


fun main() {
    val androidFactory: OSAbstractFactory = AndroidFactory()
    val aButton = androidFactory.createButton()
    val aDialog = androidFactory.createDialog()

    val iosFactory: OSAbstractFactory = IOSFactory()
    val iButton = iosFactory.createButton()
    val iDialog = iosFactory.createDialog()
}

abstract class OSAbstractFactory {
    abstract fun createButton(): Button
    abstract fun createDialog(): Dialog
}

class AndroidFactory: OSAbstractFactory() {
    override fun createButton(): Button = AndroidButton()
    override fun createDialog(): Dialog = AndroidDialog()
}

class IOSFactory: OSAbstractFactory() {
    override fun createButton(): Button = IOSButton()
    override fun createDialog(): Dialog = IOSDialog()
}

interface Button
interface Dialog

class AndroidButton: Button
class AndroidDialog: Dialog
class IOSButton: Button
class IOSDialog: Dialog