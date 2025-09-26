package com.calyrsoft.ucbp1.features.profile.domain.usecase

import com.calyrsoft.ucbp1.features.profile.domain.model.ProfileModel
import com.calyrsoft.ucbp1.features.profile.domain.model.vo.*
import com.calyrsoft.ucbp1.features.profile.domain.repository.IProfileRepository
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.coroutines.test.runTest

class GetProfileUseCaseTest {

    private class FakeRepoSuccess : IProfileRepository {
        override fun fetchData(): Result<ProfileModel> {
            val model = ProfileModel(
                name = Name.create("Mateo"),
                email = Email.create("mateo@example.com"),
                pathUrl = PathUrl.create("https://example.com/a.png"),
                cellphone = PhoneNumber.create("71234567"),
                summary = Summary.create("Estudiante de Ing. de Sistemas en UCB.")
            )
            return Result.success(model)
        }
    }

    private class FakeRepoFailure : IProfileRepository {
        override fun fetchData(): Result<ProfileModel> =
            Result.failure(IllegalStateException("falló backend"))
    }

    @Test
    fun `devuelve success y respeta delay virtual de 3000ms`() = runTest {
        val usecase = GetProfileUseCase(FakeRepoSuccess())

        val start = testScheduler.currentTime
        val result = usecase.invoke()
        val end = testScheduler.currentTime

        assertTrue(result.isSuccess)
        assertEquals(3000, (end - start).toInt())
    }

    @Test
    fun `propaga failure del repositorio`() = runTest {
        val usecase = GetProfileUseCase(FakeRepoFailure())
        val result = usecase.invoke()
        assertTrue(result.isFailure)
    }
}
