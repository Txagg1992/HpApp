package com.curiousapps.footsies.data

import com.curiousapps.footsies.domain.StudentItem
import com.curiousapps.footsies.domain.StudentRepository
import com.curiousapps.footsies.network.HogwartsApi
import okio.IOException
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(
    private val hogwartsApi: HogwartsApi
) : StudentRepository {
    override suspend fun fetchAllStudents(): Result<List<StudentItem>> {
        try {
            hogwartsApi.fetchAllStudents()
                .let {
                    return Result.success(it)
                }

        } catch (e: IOException) {
            return Result.failure(e)
        }
    }
}