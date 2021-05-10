package nowowiejski.m.myapp.data.remote.model

import nowowiejski.m.myapp.domain.model.MyCv

data class CvDto(
    val user: UserDto,
    val address: AddressDto,
    val education: EducationDto,
    val experiences: List<ExperienceDto>
) {
    fun mapToDomain(): MyCv =
        MyCv(user = user.toUser(),
            address = address.toAddress(),
            education = education.toEducation(),
            experienceList = experiences.map {
                it.toExperience()
            }
        )
}