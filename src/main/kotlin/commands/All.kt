package commands

import Storage

class All {
    companion object: Command {
        override fun execute(arguments: List<String>) {
            val passwords = Storage.get()

            if (passwords.isEmpty()) return println("No passwords")

            passwords.forEachIndexed {
                index, item -> run {
                    var message = "$index. ${item.name}"

                    if ("-u" in arguments) message += " ${item.username}"
                    if ("-p" in arguments) message += " ${item.password}"

                    println(message)
                }
            }
        }
    }
}