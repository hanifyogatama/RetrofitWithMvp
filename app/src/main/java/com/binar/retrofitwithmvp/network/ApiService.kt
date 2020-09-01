package com.binar.kotlinretrofit.network


import com.binar.retrofitwithmvp.pojo.*
import retrofit2.Call
import retrofit2.http.*


interface ApiService{
    @GET("persons")
    fun getAllPersons(): Call<GetPersonsResponse>

    @POST("persons")
    fun addPerson(@Body postPersonBody: PostPersonBody): Call<PostPersonResponse>

    @PUT("person/{id}")
    fun updatePerson(@Path("id") id: PutPersonBody, @Body putPersonBody: String): Call<PutPersonResponse>

    @DELETE("person/{id}")
    fun deletePerson(@Path("id") id: String): Call<DeletePersonResponse>
}
