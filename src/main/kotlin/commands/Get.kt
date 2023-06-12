package commands

import Storage

class Get {
    companion object: Command {
        override fun execute(arguments: List<String>) {
            if (arguments.isEmpty()) return println("Invalid command syntax")
            val index = arguments[0].toIntOrNull() ?: return println("Invalid command syntax")

            val passwords = Storage.get()

            if (index !in passwords.indices) return println("Index not found")

            val item = passwords[index]

            val message = "$index. ${item.name} ${item.username} ${item.password}"

            println(message)
        }
    }
}
