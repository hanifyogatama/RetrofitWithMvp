package com.binar.retrofitwithmvp.update

import com.binar.kotlinretrofit.network.ApiClient
import com.binar.kotlinretrofit.pojo.GetPersonsResponse
import com.binar.retrofit.pojo.PutPersonBody
import com.binar.retrofit.pojo.PutPersonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdatePersonPresenter(val listener: Listener) {

    fun updatePerson(result: GetPersonsResponse.Result){
        val objectPut = PutPersonBody(result.firstName, result.lastName)
        ApiClient.apiService.updatePerson(objectPut, result.iD.toString()).enqueue(object :
            Callback<PutPersonResponse> {

            override fun onFailure(call: Call<PutPersonResponse>, t: Throwable) {
                t.message?.let {
                    listener.onUpdatePersonFailed(it)
                }
            }

            override fun onResponse(
                call: Call<PutPersonResponse>,
                response: Response<PutPersonResponse>
            ) {
                listener.onUpdatePersonSuccess("Sukses merubah data")
            }
        })
    }


    interface Listener{
        fun onUpdatePersonSuccess(message: String)
        fun onUpdatePersonFailed(errorMessage: String)
    }
}