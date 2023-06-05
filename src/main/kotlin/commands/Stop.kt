package commands

import kotlin.system.exitProcess

class Stop {
    companion object: Command {
        override fun execute(arguments: List<String>) {
            println("Snaky stopped")
            exitProcess(0)
        }
    }
}
