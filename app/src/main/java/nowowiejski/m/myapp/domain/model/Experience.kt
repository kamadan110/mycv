package nowowiejski.m.myapp.domain.model

data class Experience(
        val role: String,
        val company: String?,
        val address: Address,
        val date: String,
        val description: String?,
        val technicalSkills: List<String>?,
)