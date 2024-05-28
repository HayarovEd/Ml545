package com.smartloanadvisor.app.data.remote

import com.smartloanadvisor.app.data.remote.dto.BaseDto
import retrofit2.http.GET

interface ApiServer {
    @GET ("545/db.json")
    suspend fun getDataDb () : BaseDto
}