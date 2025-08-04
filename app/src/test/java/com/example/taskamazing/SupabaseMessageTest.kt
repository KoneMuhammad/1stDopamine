package com.example.taskamazing

import com.example.taskamazing.datalayer.domainmodel.ModelTaskMessage
import com.example.taskamazing.datalayer.dto.ModelDTOTaskMessage
import com.example.taskamazing.datalayer.enumclass.type_of_task
import com.example.taskamazing.datalayer.repository.supabaserepository.SupabaseTaskMessageRepository
import com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase.WrapperMessageSupabase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import java.time.Instant
import kotlin.test.Test


class SupabaseMessageTests {

    @Test
    fun `get single message returns correct data`() = runTest {
        val expected = ModelDTOTaskMessage(
            id = 1,
            type_of_task = type_of_task.DHIKR,
            task_message = "message",
            emblem_url = "test.png"
        )

        val fakeWrapper = object : WrapperMessageSupabase {
            override suspend fun upsertTaskMessage(taskMessage: ModelTaskMessage) {
                error("not used")
            }

            override suspend fun getTaskMessage(id: Long): ModelDTOTaskMessage {
                return expected
            }

            override suspend fun getMultipleTaskMessage(ids: Set<Long>): List<ModelDTOTaskMessage> {
                error("not used")
            }
        }

        val repo = SupabaseTaskMessageRepository(fakeWrapper)

        val result = repo.getTaskMessage(1).first()

        assertEquals(expected, result)
    }

    @Test
    fun `get multiple messages returns correct data`() = runTest {
        val expected = listOf(
            ModelDTOTaskMessage(1, type_of_task.DHIKR, "message1", "url1"),
            ModelDTOTaskMessage(2, type_of_task.DHIKR, "message2", "url2")
        )

        val fakeWrapper = object : WrapperMessageSupabase {
            override suspend fun upsertTaskMessage(taskMessage: ModelTaskMessage) {
                error("not used")
            }

            override suspend fun getTaskMessage(id: Long): ModelDTOTaskMessage {
                error("not used")
            }

            override suspend fun getMultipleTaskMessage(ids: Set<Long>): List<ModelDTOTaskMessage> {
                return expected
            }
        }

        val repo = SupabaseTaskMessageRepository(fakeWrapper)

        val result = repo.getMultipleTaskMessage(setOf(1, 2)).first()

        assertEquals(expected, result)
    }

    @Test
    fun `upsert message triggers without error`() = runTest {
        val message = ModelTaskMessage(
            id = 3,
            type_of_task = type_of_task.DHIKR,
            task_message = "content",
            emblem_url = "logo.png",
            created_at = Instant.parse("2024-01-01T00:00:00Z")
        )

        var called = false

        val fakeWrapper = object : WrapperMessageSupabase {
            override suspend fun upsertTaskMessage(taskMessage: ModelTaskMessage) {
                called = true
            }

            override suspend fun getTaskMessage(id: Long): ModelDTOTaskMessage {
                error("not used")
            }

            override suspend fun getMultipleTaskMessage(ids: Set<Long>): List<ModelDTOTaskMessage> {
                error("not used")
            }
        }

        val repo = SupabaseTaskMessageRepository(fakeWrapper)

        repo.upsertTaskMessage(message)

        assertTrue(called)
    }
}