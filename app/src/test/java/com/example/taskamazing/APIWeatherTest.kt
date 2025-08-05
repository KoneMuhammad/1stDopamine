package com.example.taskamazing

import com.example.taskamazing.datalayer.dto.DTOCurrentWeather
import com.example.taskamazing.datalayer.apiservice.WeatherApiService
import com.example.taskamazing.datalayer.domainmodel.Condition
import com.example.taskamazing.datalayer.domainmodel.CurrentWeather
import com.example.taskamazing.datalayer.repository.weatherapirepository.WeatherRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import retrofit2.Response
import kotlin.test.Test


class APIWeatherTest {
    @Test
    fun `fetch Weather emits DTO when API call is successful`() = runTest {
        // 1. Fake API response (network model)
        val apiResponse = CurrentWeather(
            temp_f = 72.0,
            condition = Condition("Sunny", icon = "", code = 1000),
            dewpoint_c = 0.0,
            dewpoint_f = 0.0,
            wind_mph = 0.0,
            wind_kph = 0.0,
            wind_degree = 0,
            wind_dir = "N",
            pressure_mb = 1013.0,
            pressure_in = 29.92,
            precip_mm = 0.0,
            precip_in = 0.0,
            humidity = 20,
            cloud = 10,
            is_day = 1,
            uv = 5.0,
            gust_mph = 0.0,
            gust_kph = 0.0,
            last_updated = "2024-01-01",
            last_updated_epoch = 0,
            temp_c = 20.20,
            feelslike_c = 22.0,
            feelslike_f = 72.0,
            windchill_c = 22.0,
            windchill_f = 72.0,
            heatindex_c = 20.2,
            heatindex_f = 10.10
        )

        // 2. Fake API service
        val fakeApi = object : WeatherApiService {
            override suspend fun getWeather(
                location: String,
                apiKey: String
            ): Response<CurrentWeather> {
                return Response.success(apiResponse)
            }
        }

        // 3. Repo
        val repo = WeatherRepository(fakeApi)

        // 4. Act
        val result = repo.fetchWeather("NY", "123").first()

        // 5. Assert (expected DTO from your .toDTO() conversion)
        val expected = DTOCurrentWeather(
            tempCelsius = 20.20,
            conditionText = "Sunny",
            humidity = 20
        )

        assertEquals(expected, result)
    }
}