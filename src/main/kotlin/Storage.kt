import kotlin.system.exitProcess

import entities.Password

import kotlinx.serialization.SerializationException
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

import java.io.File

class Storage {
    companion object {
        private val file = File("passwords.json")

        private lateinit var passwords: MutableList<Password>

        fun get() = passwords
        fun get(index: Int) = passwords[index]

        fun load() {
            try {
                if (!file.exists()) {
                    file.createNewFile()
                    file.writeText("[]")

                    println("The passwords.json file was not found and therefore was generated automatically")
                }

                passwords = Json.decodeFromString(file.readText())
            } catch (exception: SerializationException) {
                println("An error occurred while loading data from the passwords.json file")
                exitProcess(1)
            }
        }

        fun reload() {
            try {
                passwords = Json.decodeFromString(file.readText())
            } catch (exception: SerializationException) {
                println("An error occurred while loading data from the passwords.json file")
                exitProcess(1)
            }
        }

        private fun updateFile() = file.writeText(Json.encodeToString(passwords))

        fun add(name: String, username: String, password: String) {
            passwords.add(Password(name, username, password))

            updateFile()
        }

        fun remove(index: Int) {
            passwords.removeAt(index)

            updateFile()
        }

        fun edit(index: Int, newName: String, newUsername: String, newPassword: String) {
            val password = passwords[index]

            password.name = newName
            password.username = newUsername
            password.password = newPassword

            updateFile()
        }
    }
}