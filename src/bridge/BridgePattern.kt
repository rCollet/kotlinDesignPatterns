package bridge

fun main() {
    val book = Book("img book", "book", "desc book")
    val artist = Artist("img artist", "artist", "desc artist")
    val bookR = BookResource(book)
    val artistR = ArtistResource(artist)

    val largeView: View = LargeScreenView(bookR)
    largeView.show()

    val smallView: View = SmallScreenView(artistR)
    smallView.show()
}

interface View {
    val resource: Resource
    fun show()
}

interface Resource {
    fun image(): String
    fun title(): String
    fun description(): String
}

class LargeScreenView(override val resource: Resource) : View {
    override fun show() {
        println(resource.image())
        println(resource.title())
        println(resource.description())
    }
}

class SmallScreenView(override val resource: Resource) : View {
    override fun show() {
        println(resource.image())
    }
}

class BookResource(private val book: Book) : Resource {
    override fun image(): String = book.image

    override fun title(): String = book.title

    override fun description(): String = book.desc
}

class ArtistResource(private val artist: Artist) : Resource {
    override fun image(): String = artist.image

    override fun title(): String = artist.name

    override fun description(): String = artist.bio
}

data class Book(val image: String, val title: String, val desc: String)
data class Artist(val name: String, val bio: String, val image: String)