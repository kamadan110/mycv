package nowowiejski.m.myapp.data.remote.model

import nowowiejski.m.myapp.domain.model.Experience

data class ExperienceDto(
        val role: String,
        val company: String?,
        val address: AddressDto,
        val date: String,
        val description: String?,
        val technicalSkills: List<String>?,
) {
    fun toExperience() = Experience(
            role,
            company,
            address.toAddress(),
            date,
            description,
            technicalSkills
    )
}