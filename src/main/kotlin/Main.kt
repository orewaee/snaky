import commands.*

fun main() {
    Storage.load()

    while (true) {
        val arguments = readln().split(" ")

        val command = when (arguments[0]) {
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
