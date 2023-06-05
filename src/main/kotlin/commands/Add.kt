package commands

import Storage

class Add {
    companion object: Command {
        override fun execute(arguments: List<String>) {
            if (arguments.size < 3) return println("Invalid command syntax")

            val name = arguments[0]
            val username = arguments[1]
            val password = arguments[2]

            Storage.add(name, username, password)

            println("Password added")
        }
    }
}
