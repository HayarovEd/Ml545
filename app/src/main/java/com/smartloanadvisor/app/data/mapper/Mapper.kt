package com.smartloanadvisor.app.data.mapper

import com.smartloanadvisor.app.data.remote.dto.server_data.BaseDto
import com.smartloanadvisor.app.domain.model.AppConfig
import com.smartloanadvisor.app.domain.model.BaseData
import com.smartloanadvisor.app.domain.model.Loan

fun BaseDto.mapToBaseData(): BaseData {
    return BaseData(
        appConfig = AppConfig(
            privacyPolicyHtml = this.appConfigDto.privacyPolicyHtml,
            showCalculatorItem = this.appConfigDto.showCalculatorItem,
            showChat = this.appConfigDto.showChat,
            showNewsItem = this.appConfigDto.showNewsItem,
            showPhoneAuthentication = this.appConfigDto.showPhoneAuthentication,
            userTermHtml = this.appConfigDto.userTermHtml
        ),
        loans = this.loanDtos.map {
            Loan(
                screen = it.screen,
                name = it.name,
                order = it.order,
                percent = it.percentPrefix + " " + it.percent + " " + it.percentPostfix,
                amounts = it.summPrefix + " " + it.summMin + " " + it.summMid + " " + it.summMax + " " + it.summPostfix,
                terms = it.termPrefix +" "+ it.termMin +" " + it.termMid +" " + it.termMax +" " + it.termPostfix,
                description = it.description,
                hidePercentFields = it.hidePercentFields,
                hideTermFields = it.hideTermFields,
                id = it.id,
                isActive = it.isActive,
                itemId = it.itemId,
                orderButtonText = it.orderButtonText,
                position = it.position,
                score = it.score,
                showCash = it.showCash,
                showQiwi = it.showQiwi,
                showVisa = it.showVisa,
                showMir = it.showMir,
                showMastercard = it.showMastercard,
                showYandex = it.showYandex
            )
        }
    )
}
