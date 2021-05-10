package nowowiejski.m.myapp.domain

import io.mockk.every
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import nowowiejski.m.myapp.domain.model.MyCv
import nowowiejski.m.myapp.domain.repository.CvRepository
import org.junit.Test

class GetCvUseCaseTest {

    @Test
    fun `when use case is invoked then execute getCv method from repository`() {
        val repository = mockk<CvRepository>(relaxed = true)
        val useCase = GetCvUseCase(repository)
        val myCv = mockk<MyCv>()

        every { repository.getCV() } returns Single.just(myCv)

        useCase(Unit).test()
            .assertValueCount(1)
            .assertResult(myCv)
    }
}