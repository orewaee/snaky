package commands

import Storage

class Edit {
    companion object: Command {
        override fun execute(arguments: List<String>) {
            if (arguments.size < 4) return println("Invalid command syntax")

            val index = arguments[0].toIntOrNull() ?: return println("Invalid command syntax")

            val passwords = Storage.get()

            if (index !in passwords.indices) return println("Index not found")

            val newName = if (arguments[1] != "-") arguments[1] else passwords[index].name
            val newUsername = if (arguments[2] != "-") arguments[2] else passwords[index].username
            val newPassword = if (arguments[3] != "-") arguments[3] else passwords[index].password

            Storage.edit(index, newName, newUsername, newPassword)

            println("Password edited")
        }
    }
}
