package template

fun main() {
    val userRecord: Record = User("bob")
    val postRecord: Record = Post("coucou")

    userRecord.save()
    postRecord.save()
}

abstract class Record {
    fun save() {
        beforeSave()
        println("Saving request sending...")
        onSuccess()
    }

    internal abstract fun onSuccess()
    internal abstract fun beforeSave()
}

class User(val name: String): Record() {
    override fun onSuccess() {
        println("User saved.")
    }

    override fun beforeSave() {
        println("preparing user to be saved.")
    }
}

class Post(val content: String): Record() {
    override fun onSuccess() {
        println("Post saved.")
    }

    override fun beforeSave() {
        println("preparing post to be saved.")
    }
}