package commands

import Storage
import ru.orewaee.krayon.italic

class Find {
    companion object: Command {
        override fun execute(arguments: List<String>) {
            if (arguments.isEmpty()) return println("Invalid command syntax. Use: " + "find <name>".italic)

            val name = arguments[0].lowercase()

            val passwords = Storage.get()

            var matches = 0
            passwords.forEachIndexed {
                index, item -> run {
                    if (item.name.lowercase() == name) {
                        matches++

                        var message = "$index. ${item.name}"

                        if ("-u" in arguments) message += " ${item.username}"
                        if ("-p" in arguments) message += " ${item.password}"

                        println(message)
                    }
                }
            }

            if (matches == 0) println("Passwords not found")
        }
    }
}
