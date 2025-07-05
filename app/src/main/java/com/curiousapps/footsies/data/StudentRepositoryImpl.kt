package com.curiousapps.footsies.data

import android.util.Log
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
                    Log.e("StudentRepositoryImpl", "Got the student list")
                    return Result.success(it)
                }

        } catch (e: IOException) {
            return Result.failure(e)
        }
    }

    override suspend fun fetchOneStudent(id: String): Result<List<StudentItem>> {
        try {
            hogwartsApi.fetchOneStudent(id = id).let {

                Log.e("StudentRepositoryImpl", "Got the single student")
                Log.e("StudentRepositoryImpl",
                    "${hogwartsApi.fetchOneStudent(id)}")
                return Result.success(it)
            }

        }catch (e: IOException){
            Log.e("StudentRepositoryImpl", e.message.toString())
            return Result.failure(e)
        }
    }
}