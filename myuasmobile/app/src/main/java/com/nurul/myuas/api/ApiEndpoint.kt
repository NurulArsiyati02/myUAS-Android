package com.nurul.myuas.api

import com.nurul.myuas.Model
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("data.php")
    fun data() : Call<Model>
}