package nowowiejski.m.myapp.presentation.model

import nowowiejski.m.myapp.domain.model.*


data class MyCvDisplayable(
        val user: User,
        val address: Address,
        val education: Education,
        val experienceList: List<Experience>
) {
    constructor(cv: MyCv) : this(
            cv.user,
            cv.address,
            cv.education,
            cv.experienceList
    )
}
