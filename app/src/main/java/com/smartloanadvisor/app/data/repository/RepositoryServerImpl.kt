package com.smartloanadvisor.app.data.repository

import android.util.Log
import com.smartloanadvisor.app.data.mapper.mapToBaseData
import com.smartloanadvisor.app.data.remote.ApiServer
import com.smartloanadvisor.app.domain.model.BaseData
import com.smartloanadvisor.app.domain.repository.RepositoryServer
import com.smartloanadvisor.app.domain.utils.Resource
import com.smartloanadvisor.app.domain.utils.Resource.Error
import com.smartloanadvisor.app.domain.utils.Resource.Success
import javax.inject.Inject

class RepositoryServerImpl @Inject constructor(
    private val apiServer: ApiServer,
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

}