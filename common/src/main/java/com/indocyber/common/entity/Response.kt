package com.indocyber.common.entity


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("photos")
    val data : ArrayList<ResponseItem>
)