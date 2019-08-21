package decorator

fun main() {
    val listToFilter = NameList(listOf('A', 'B', 'C', 'D', 'E'))
    val filteredList = LetterAFilter(LetterCFilter(listToFilter)).getFilteredList()
    println(filteredList)
}

interface FilteringList {
    fun getFilteredList(): List<Char>
}

class NameList(private val list: List<Char>): FilteringList {
    override fun getFilteredList(): List<Char> {
        return list;
    }
}

interface FilterDecorator: FilteringList {
    val filteringList: FilteringList
}

class LetterAFilter(override val filteringList: FilteringList): FilterDecorator {
    override fun getFilteredList(): List<Char> {
        return filteringList.getFilteredList().filter { it != 'A' }
    }
}

class LetterCFilter(override val filteringList: FilteringList): FilterDecorator {
    override fun getFilteredList(): List<Char> {
        return filteringList.getFilteredList().filter { it != 'C' }
    }
}