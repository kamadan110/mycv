package nowowiejski.m.myapp.data.remote.model

import nowowiejski.m.myapp.domain.model.User

data class UserDto(
        val name: String,
        val email: String,
        val phoneNumber: String
) {
    fun toUser() = User(
            name,
            email,
            phoneNumber
    )
}