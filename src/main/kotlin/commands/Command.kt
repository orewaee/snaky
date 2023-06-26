package commands

interface Command {
    fun execute(arguments: List<String>)
}
