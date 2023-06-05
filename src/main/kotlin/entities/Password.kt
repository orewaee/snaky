package entities

import kotlinx.serialization.Serializable

@Serializable
data class Password(
    var name: String,
    var username: String,
    var password: String
)
