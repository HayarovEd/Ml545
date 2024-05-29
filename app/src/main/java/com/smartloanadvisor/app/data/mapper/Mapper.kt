package com.smartloanadvisor.app.data.mapper

import com.smartloanadvisor.app.data.remote.dto.cbr.CbrDto
import com.smartloanadvisor.app.data.remote.dto.server_data.BaseDto
import com.smartloanadvisor.app.domain.model.AppConfig
import com.smartloanadvisor.app.domain.model.BaseData
import com.smartloanadvisor.app.domain.model.CNY
import com.smartloanadvisor.app.domain.model.CbrData
import com.smartloanadvisor.app.domain.model.Currency
import com.smartloanadvisor.app.domain.model.EUR
import com.smartloanadvisor.app.domain.model.Loan
import com.smartloanadvisor.app.domain.model.USD

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

fun CbrDto.mapToCberData(): CbrData {
    return CbrData(
        date = formatCbrDate(this.date),
        previousDate = formatCbrDate(this.previousDate),
        currency = Currency(
            cNY = CNY(
                name = this.currencyDto.cNY.name,
                charCode = this.currencyDto.cNY.charCode,
                nominal = this.currencyDto.cNY.nominal,
                value = this.currencyDto.cNY.value,
                previous = this.currencyDto.cNY.previous
            ),
            eUR = EUR(
                name = this.currencyDto.eUR.name,
                charCode = this.currencyDto.eUR.charCode,
                nominal = this.currencyDto.eUR.nominal,
                value = this.currencyDto.eUR.value,
                previous = this.currencyDto.eUR.previous
            ),
            uSD = USD(
                name = this.currencyDto.uSD.name,
                charCode = this.currencyDto.uSD.charCode,
                nominal = this.currencyDto.uSD.nominal,
                value = this.currencyDto.uSD.value,
                previous = this.currencyDto.uSD.previous
            )
        )
    )
}


private fun formatCbrDate(current: String): String {
    val month = current.substring(5, 7)
    val day = current.substring(8, 10)
    return "$day.$month"
}
