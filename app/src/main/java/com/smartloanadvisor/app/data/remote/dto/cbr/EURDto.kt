package com.smartloanadvisor.app.data.remote.dto.cbr


import com.google.gson.annotations.SerializedName

data class EURDto(
    @SerializedName("CharCode")
    val charCode: String,
    @SerializedName("ID")
    val iD: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Nominal")
    val nominal: Int,
    @SerializedName("NumCode")
    val numCode: String,
    @SerializedName("Previous")
    val previous: Double,
    @SerializedName("Value")
    val value: Double
)