interface Listable

class ArchiveSet : Listable {
    var archives: MutableList<Archive> = mutableListOf()
}

class Archive (val name: String) : Listable {
    var notes: MutableList<Note> = mutableListOf()
}

class Note (val name: String, val text: String) :Listable {
    override fun toString(): String {
        return "Заметка \"$name\":\n $text"
    }
}