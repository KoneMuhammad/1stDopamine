package com.example.taskamazing

import com.example.taskamazing.datalayer.domainmodel.ModelUser
import com.example.taskamazing.datalayer.repository.supabaserepository.SupabaseUserRepository
import com.example.taskamazing.datalayer.repository.supabaserepository.wrappersupabase.WrapperUserSupabase
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import java.time.Instant
import kotlin.test.Test

class SupabaseUserTests {

    @Test
    fun `add new user calls wrapper`() = runTest {
        var called = false

        val fakeWrapper = object : WrapperUserSupabase {
            override suspend fun addNewUser(email: String, password: String) {
                called = true
            }

            override suspend fun upsertNewUser(user: ModelUser) = Unit
            override suspend fun deleteUser(id: Long) = Unit
        }

        val repo = SupabaseUserRepository(fakeWrapper)
        repo.addNewUser("a@b.com", "pass")

        assertTrue(called)
    }

    @Test
    fun `upsert user calls wrapper`() = runTest {
        var called = false

        val fakeWrapper = object : WrapperUserSupabase {
            override suspend fun addNewUser(email: String, password: String) = Unit
            override suspend fun upsertNewUser(user: ModelUser) {
                called = true
            }

            override suspend fun deleteUser(id: Long) = Unit
        }

        val repo = SupabaseUserRepository(fakeWrapper)
        repo.upsertNewUser(ModelUser(
            email = "x@y.com",
            created_at = Instant.parse("2024-01-01T00:00:00Z"),
            display_name = "wow",
            id = 1
        ))

        assertTrue(called)
    }

    @Test
    fun `delete user calls wrapper`() = runTest {
        var called = false

        val fakeWrapper = object : WrapperUserSupabase {
            override suspend fun addNewUser(email: String, password: String) = Unit
            override suspend fun upsertNewUser(user: ModelUser) = Unit
            override suspend fun deleteUser(id: Long) {
                called = true
            }
        }

        val repo = SupabaseUserRepository(fakeWrapper)
        repo.deleteUser(5)

        assertTrue(called)
    }
}