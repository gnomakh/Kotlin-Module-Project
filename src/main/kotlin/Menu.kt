import java.util.*

class Menu {
    private var archiveSet: ArchiveSet = ArchiveSet()
    private var currentArchive = 0

    fun goToMainScreen(mainScreen: ArchiveSet) {
        archiveSet = mainScreen
        while(true) {
            printMenu(mainScreen)
            executeCommand(mainScreen)
        }
    }

    private fun goToArchive(archive: Archive) {
        while (true) {
            printMenu(archive)
            executeCommand(archive)
        }
    }

    private fun goToNote(note: Note) {
        while(true) {
            printMenu(note)
            executeCommand(note)
        }
    }

    private fun printMenu(item: Listable) {
        printBlue("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::")
        when(item) {
            is ArchiveSet -> {
                println("1. Закрыть приожение\n" +
                        "2. Создать архив заметок")
                if (item.archives.size == 0) println("// Архивов с заметками не обнаружено...")
                else {
                    println("// Имеющиеся архивы заметок:")
                    for (unit in item.archives) {println("${(item.archives.indexOf(unit)) + 3}. ${unit.name}")}
                }
            }
            is Archive -> {
                println("Архив \"${item.name}\":\n" +
                        "1. В главное меню\n" +
                        "2. Создать заметку")
                if (item.notes.size == 0) println("// Заметок нет, архив пуст...")
                else {
                    println("// Заметки в архиве:")
                    for (unit in item.notes) {println("${(item.notes.indexOf(unit)) + 3}. ${unit.name}")}
                }
            }
            is Note -> {
                println("1. Вернуться к архиву\n ${item.toString()}")
            }
        }
        printBlue("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::")
    }

    private fun executeCommand(item: Listable) {
        val noteCommandError = "Отсюда можно только выйти..."
        val noSuchCommand = "Такой команды нет!"

        val scan = Scanner(System.`in`)
        var command = 0
        while(true) {
            try {
                command = scan.nextInt()
            } catch (e: Exception) {
                printRed("Введите число!")
                scan.next()
                return
            }

            if (command <= 0) {
                printRed("Введите положительное число!")
                return
            } else break
        }
        when(command) {
            1 -> { when(item){
                is ArchiveSet -> System.exit(0)
                is Archive -> goToMainScreen(archiveSet)
                is Note -> goToArchive(archiveSet.archives[currentArchive])
            }}
            2 -> { when(item){
                is ArchiveSet -> createElement(item)
                is Archive -> createElement(item)
                is Note -> printRed(noteCommandError)
            }
            }
            else -> { when(item) {
                is ArchiveSet -> if(command > (item.archives.size + 2)) printRed(noSuchCommand) else {
                    currentArchive = command - 3
                    goToArchive(item.archives[command - 3])
                }
                is Archive -> if(command > (item.notes.size + 2)) printRed(noSuchCommand)  else goToNote(item.notes[command - 3])
                else -> printRed(noteCommandError)
            }
            }
        }
    }
}