package nowowiejski.m.myapp.data.remote.model

import nowowiejski.m.myapp.domain.model.Address


data class AddressDto(
        val city: String,
        val street: String,
        val postCode: String,
        val country: String
) {
    fun toAddress(): Address = Address(
            city,
            street,
            postCode,
            country
    )
}