import java.util.*

fun createElement(item: Listable) {
    val scan = Scanner(System.`in`)
    while(true) {
        print("Введите имя ${if (item is ArchiveSet) "архива" else "заметки"}: ")

        var name = scan.nextLine()

        if (name == "") {
            printRed("Имя не может быть пустым!")
            continue
        }

        when (item) {
            is ArchiveSet -> {
                item.archives.add(Archive(name))
                return
            }
            is Archive -> {
                while(true) {
                    print("Введите текст заметки: ")
                    val title = scan.nextLine()
                    if (title == "") {
                        printRed("Заметка не может быть пустой!")
                        continue
                    } else {
                        item.notes.add(Note(name, title))
                        return
                    }

                }
            }
        }
    }
}

fun printRed(message: String){
    val red = "\u001b[31m"
    val reset = "\u001b[0m"

    println(red + message + reset)
}

fun printBlue(message: String){
    val blue = "\u001b[96m"
    val reset = "\u001b[0m"

    println(blue + message + reset)
}

