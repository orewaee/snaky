import commands.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import plugins.configureHTTP
import plugins.configureRouting
import plugins.configureSerialization

fun main() {
    Storage.load()

    runBlocking {
        launch(Dispatchers.Default) {
            embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
                .start(wait = true)
        }

        launch(Dispatchers.Default) {
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
    }
}

fun Application.module() {
    configureHTTP()
    configureSerialization()
    configureRouting()
}
