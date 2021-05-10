package nowowiejski.m.myapp.data.remote.model

import nowowiejski.m.myapp.domain.model.Education

data class EducationDto(
    val address: AddressDto,
    val schoolName: String
) {
    fun toEducation() = Education(
        address.toAddress(),
        schoolName
    )
}