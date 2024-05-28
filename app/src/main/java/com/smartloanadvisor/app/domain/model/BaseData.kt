package com.smartloanadvisor.app.domain.model

data class BaseData(
    val appConfig: AppConfig,
    val loans: List<Loan>
)
