package com.curiousapps.footsies.network

import com.curiousapps.footsies.domain.StudentItem
import com.curiousapps.footsies.util.URL_EXT
import retrofit2.http.GET

interface HogwartsApi {

    @GET(URL_EXT)
    suspend fun fetchAllStudents(): List<StudentItem>
}