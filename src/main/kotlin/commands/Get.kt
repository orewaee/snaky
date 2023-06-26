package commands

import Storage
import ru.orewaee.krayon.italic

class Get {
    companion object: Command {
        override fun execute(arguments: List<String>) {
            if (arguments.isEmpty()) return println("Invalid command syntax. Use: " + "get <index>".italic)
            val index = arguments[0].toIntOrNull() ?: return println("Invalid command syntax")

            val passwords = Storage.get()

            if (index !in passwords.indices) return println("Index not found")

            val item = passwords[index]

            val message = "$index. ${item.name} ${item.username} ${item.password}"

            println(message)
        }
    }
}
