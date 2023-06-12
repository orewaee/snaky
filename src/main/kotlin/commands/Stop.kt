package commands

import Snaky

class Stop {
    companion object: Command {
        override fun execute(arguments: List<String>) =
            Snaky.stop("Snaky stopped", 0)
    }
}
