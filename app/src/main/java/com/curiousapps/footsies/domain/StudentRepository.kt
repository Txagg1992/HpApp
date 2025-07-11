package com.curiousapps.footsies.domain

import dagger.hilt.android.scopes.ActivityScoped

@ActivityScoped
interface StudentRepository {

    suspend fun fetchAllStudents(): Result<List<StudentItem>>

    suspend fun fetchOneStudent(id: String): Result<List<StudentItem>>
}