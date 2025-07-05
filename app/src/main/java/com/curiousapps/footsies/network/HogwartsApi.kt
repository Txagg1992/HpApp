package com.curiousapps.footsies.network

import com.curiousapps.footsies.domain.StudentItem
import com.curiousapps.footsies.util.URL_EXT
import com.curiousapps.footsies.util.URL_ONE
import retrofit2.http.GET
import retrofit2.http.Path

interface HogwartsApi {

    @GET(URL_EXT)
    suspend fun fetchAllStudents(): List<StudentItem>
    @GET(URL_ONE)
    suspend fun fetchOneStudent(
        @Path("id") id: String
    ): List<StudentItem>
}