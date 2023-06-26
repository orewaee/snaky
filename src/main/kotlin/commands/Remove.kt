package commands

import Storage
import ru.orewaee.krayon.italic

class Remove {
    companion object: Command {
        override fun execute(arguments: List<String>) {
            if (arguments.size != 1) return println("Invalid command syntax. Use: " + "remove <index>".italic)
            val index = arguments[0].toIntOrNull() ?: return println("Invalid command syntax")

            val passwords = Storage.get()

            if (index !in passwords.indices) return println("Index not found")

            Storage.remove(index)

            println("Password removed")
        }
    }
}
