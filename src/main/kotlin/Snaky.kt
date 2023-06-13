import commands.*

import ru.orewaee.krayon.green

import kotlin.system.exitProcess

class Snaky {
    companion object {
        fun start() {
            while (true) {
                print("~ ".green)
                val arguments = readln().split(" ")

                val command = when (arguments[0].lowercase()) {
                    "all" -> All
                    "find" -> Find
                    "get" -> Get
                    "add" -> Add
                    "remove" -> Remove
                    "edit" -> Edit
                    "reload" -> Reload
                    "stop" -> Stop

                    else -> null
                }

                if (command == null) println("Command not found")
                else command.execute(arguments.slice(1..arguments.lastIndex))
            }
        }

        fun stop(message: String, status: Int) {
            println(message)
            exitProcess(status)
        }
    }
}
