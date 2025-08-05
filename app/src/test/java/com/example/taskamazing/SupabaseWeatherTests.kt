package com.example.taskamazing

import com.example.taskamazing.datalayer.domainmodel.ModelTaskWeather
import com.example.taskamazing.datalayer.dto.ModelDTOTaskWeatherBackground
import com.example.taskamazing.datalayer.enumclass.weather_type
import com.example.taskamazing.datalayer.repository.supabaserepository.SupabaseTaskWeatherRepository
import com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase.WrapperWeatherSupabase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.Instant

class supabaseWeatherTests {
    @Test
    fun `get multiple weather returns correct data`() = runTest {
        // 1. Setup fake data
        val expected = listOf(
            ModelDTOTaskWeatherBackground(
                weather_type = weather_type.MOUNTAINOUSENVIRONMENT, video_url = "rain.mp4",
                id = 1
            ),
            ModelDTOTaskWeatherBackground(
                weather_type = weather_type.MOUNTAINOUSENVIRONMENT, video_url = "sun.mp4",
                id = 2
            )
        )

        // 2. Fake wrapper
        val fakeWrapper = object : WrapperWeatherSupabase {
            override suspend fun getMultipleTaskWeather(ids: Set<Long>): List<ModelDTOTaskWeatherBackground> {
                return expected
            }

            override suspend fun upsertTaskImage(taskWeather: ModelTaskWeather)
                = error("not used")


            override suspend fun getTaskWeather(id: Long): ModelDTOTaskWeatherBackground {
                error("not used")
            }
        }

        // 3. Create repo with fake wrapper
        val repo = SupabaseTaskWeatherRepository(fakeWrapper)

        // 4. Call function
        val result = repo.getMultipleTaskWeather(setOf(1, 2)).first()

        // 5. Assert
        assertEquals(expected, result)
    }
    @Test
    fun `get single weather returns correct data`() = runTest {
        val expected = ModelDTOTaskWeatherBackground(
            4, weather_type.MOUNTAINOUSENVIRONMENT,
            video_url = "newVideo"
        )

        val fakeWrapper = object : WrapperWeatherSupabase {
            override suspend fun upsertTaskImage(taskWeather: ModelTaskWeather) {
                TODO("Not yet implemented")
            }

            override suspend fun getTaskWeather(id: Long) = expected
            override suspend fun getMultipleTaskWeather(ids: Set<Long>) = error("not used")
        }

        val repo = SupabaseTaskWeatherRepository(fakeWrapper)
        val result = repo.getTaskWeather(1).first()

        assertEquals(expected, result)
    }
    @Test
    fun `upsert task image runs without error`() = runTest {
        val task = ModelTaskWeather(
            id = 5,
            created_at = Instant.parse("2024-01-01T00:00:00Z"),
            weather_type = weather_type.MOUNTAINOUSENVIRONMENT,
            video_url = "newest"
        )

        var called = false

        val fakeWrapper = object : WrapperWeatherSupabase {
            override suspend fun upsertTaskImage(taskWeather: ModelTaskWeather) {
                called = true
            }

            override suspend fun getTaskWeather(id: Long) = error("not used")
            override suspend fun getMultipleTaskWeather(ids: Set<Long>) = error("not used")
        }

        val repo = SupabaseTaskWeatherRepository(fakeWrapper)

        repo.upsertTaskImage(task)

        assertTrue(called)
    }

}