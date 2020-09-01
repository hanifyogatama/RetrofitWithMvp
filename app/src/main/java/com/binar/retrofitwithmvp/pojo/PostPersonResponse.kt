package com.binar.retrofitwithmvp.pojo


import com.google.gson.annotations.SerializedName

data class PostPersonResponse(
    @SerializedName("result")
    val result: Result
) {
    data class Result(
        @SerializedName("CreatedAt")
        val createdAt: String,
        @SerializedName("DeletedAt")
        val deletedAt: Any, // null
        @SerializedName("first_name")
        val firstName: String,
        @SerializedName("ID")
        val iD: Int, // 108
        @SerializedName("last_name")
        val lastName: String,
        @SerializedName("UpdatedAt")
        val updatedAt: String
    )
}