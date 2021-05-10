package nowowiejski.m.myapp.domain.model


data class MyCv(
    val user: User,
    val address: Address,
    val education: Education,
    val experienceList: List<Experience>
)
