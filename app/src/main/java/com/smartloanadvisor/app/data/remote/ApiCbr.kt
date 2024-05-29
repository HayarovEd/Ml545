package com.smartloanadvisor.app.data.remote

import com.smartloanadvisor.app.data.remote.dto.cbr.CbrDto
import retrofit2.http.GET

interface ApiCbr {
    @GET("daily_json.js")
    suspend fun getCbrData () : CbrDto
}