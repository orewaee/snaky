package commands

import Storage

class Reload {
    companion object: Command {
        override fun execute(arguments: List<String>) {
            Storage.reload()

            println("Snaky reloaded")
        }
    }
}
