package com.smartloanadvisor.app.data.remote.dto.cbr


import com.google.gson.annotations.SerializedName

data class CurrencyDto(
    @SerializedName("CNY")
    val cNY: CNYDto,
    @SerializedName("EUR")
    val eUR: EURDto,
    @SerializedName("USD")
    val uSD: USDDto
)