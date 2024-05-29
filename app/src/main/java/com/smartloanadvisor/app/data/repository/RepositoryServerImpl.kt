package com.smartloanadvisor.app.data.repository

import android.util.Log
import com.smartloanadvisor.app.data.mapper.mapToBaseData
import com.smartloanadvisor.app.data.mapper.mapToCberData
import com.smartloanadvisor.app.data.remote.ApiCbr
import com.smartloanadvisor.app.data.remote.ApiServer
import com.smartloanadvisor.app.domain.model.BaseData
import com.smartloanadvisor.app.domain.model.CbrData
import com.smartloanadvisor.app.domain.repository.RepositoryServer
import com.smartloanadvisor.app.domain.utils.Resource
import com.smartloanadvisor.app.domain.utils.Resource.Error
import com.smartloanadvisor.app.domain.utils.Resource.Success
import javax.inject.Inject

class RepositoryServerImpl @Inject constructor(
    private val apiServer: ApiServer,
    private val apiCbr: ApiCbr,
) : RepositoryServer {
    override suspend fun getDataDb(): Resource<BaseData> {
        return try {
            val folder = apiServer.getDataDb()
            Log.d("DATADB", "dATA DB:${folder.loanDtos.first().id}")
            Success(
                data = folder.mapToBaseData()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Error(e.message ?: "An unknown error")
        }
    }

    override suspend fun getCurrency(): Resource<CbrData> {
        return try {
            val cbrResult = apiCbr.getCbrData()
            Success(
                data = cbrResult.mapToCberData()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Error(e.message ?: "An unknown error")
        }
    }
}