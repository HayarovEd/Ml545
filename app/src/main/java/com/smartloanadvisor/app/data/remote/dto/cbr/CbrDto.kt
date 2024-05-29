package com.smartloanadvisor.app.data.remote.dto.cbr


import com.google.gson.annotations.SerializedName

data class CbrDto(
    @SerializedName("Date")
    val date: String,
    @SerializedName("PreviousDate")
    val previousDate: String,
    @SerializedName("PreviousURL")
    val previousURL: String,
    @SerializedName("Timestamp")
    val timestamp: String,
    @SerializedName("Valute")
    val currencyDto: CurrencyDto
)