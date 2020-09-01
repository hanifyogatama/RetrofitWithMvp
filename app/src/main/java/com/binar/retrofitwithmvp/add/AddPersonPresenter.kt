package com.binar.retrofitwithmvp.add



import com.binar.kotlinretrofit.network.ApiClient
import com.binar.retrofitwithmvp.pojo.PostPersonBody
import com.binar.retrofitwithmvp.pojo.PostPersonResponse

import retrofit2.Callback
import retrofit2.Response

class AddPersonPresenter(val listener: Listener) {

    fun addPerson(firstName: String, lastName: String) {

        val person = PostPersonBody(firstName, lastName)

        ApiClient.apiService.addPerson(person).enqueue(object : Callback<PostPersonResponse> {

            override fun onFailure(call: retrofit2.Call<PostPersonResponse>, t: Throwable) {
                listener.onAddPersonFailure(t.toString())
            }

            override fun onResponse(
                call: retrofit2.Call<PostPersonResponse>,
                response: Response<PostPersonResponse>
            ) {
                listener.onAddPersonSuccess("Add Success")
            }
        })

    }

    interface Listener {
        fun onAddPersonSuccess(successMessage: String)
        fun onAddPersonFailure(failureMessage: String)
    }

}