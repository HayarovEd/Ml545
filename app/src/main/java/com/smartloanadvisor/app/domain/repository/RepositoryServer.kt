package com.smartloanadvisor.app.domain.repository

import com.smartloanadvisor.app.domain.model.BaseData
import com.smartloanadvisor.app.domain.utils.Resource


interface RepositoryServer {
    suspend fun getDataDb() : Resource<BaseData>
}