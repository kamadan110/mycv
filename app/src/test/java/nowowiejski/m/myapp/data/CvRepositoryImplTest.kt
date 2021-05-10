package nowowiejski.m.myapp.data

import io.mockk.every
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import nowowiejski.m.myapp.data.remote.MyCvApi
import nowowiejski.m.myapp.data.remote.model.*
import nowowiejski.m.myapp.data.repository.CvRepositoryImpl
import nowowiejski.m.myapp.domain.model.*
import nowowiejski.m.myapp.domain.repository.CvRepository
import org.junit.Test

class CvRepositoryImplTest {


    private val cvDto = CvDto(
        user = UserDto("Michal", "test@test.pl", "22222222"),
        address = AddressDto("Kraków", "Mickiewicza", "31-100", "PL"),
        education = EducationDto(
            AddressDto("Kraków", "Mickiewicza", "31-100", "PL"),
            "PK"
        ),
        experiences = listOf(ExperienceDto(role = "Android",
            company = "Preglife",
            AddressDto("Kraków", "Mickiewicza", "31-100", "PL"),
            date = "2020-01-01",
            description = null,
            technicalSkills = null))
    )

    private val cv = MyCv(
        user = User("Michal", "test@test.pl", "22222222"),
        address = Address("Kraków", "Mickiewicza", "31-100", "PL"),
        education = Education(
            Address("Kraków", "Mickiewicza", "31-100", "PL"),
            "PK"
        ),
        experienceList = listOf(Experience(role = "Android",
            company = "Preglife",
            Address("Kraków", "Mickiewicza", "31-100", "PL"),
            date = "2020-01-01",
            description = null,
            technicalSkills = null))
    )

    @Test
    fun `fetch cv from API`() {
        val api = mockk<MyCvApi>()

        val repository: CvRepository =
            CvRepositoryImpl(api)

        every { api.getCv() } returns Single.just(cvDto)

        repository.getCV().test()
            .assertValueCount(1)
            .assertResult(cv)
    }
}