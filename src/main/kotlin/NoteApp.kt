class NoteApp {
    fun start() {
        printLogo()
        val menu = Menu()
        val archiveSet = ArchiveSet()
        menu.goToMainScreen(archiveSet)
    }
}

fun printLogo() {
    println("Welcome to")
    print("███    ███ ███████ ███    ███  ██████")
    printBlue("  ██████  ██    ██ ███    ███")
    print("████  ████ ██      ████  ████ ██    ██")
    printBlue(" ██   ██ ██    ██ ████  ████")
    print("██ ████ ██ █████   ██ ████ ██ ██    ██")
    printBlue(" ██████  ██    ██ ██ ████ ██")
    print("██  ██  ██ ██      ██  ██  ██ ██    ██")
    printBlue(" ██   ██ ██    ██ ██  ██  ██")
    print("██      ██ ███████ ██      ██  ██████")
    printBlue("  ██   ██  ██████  ██      ██")
}