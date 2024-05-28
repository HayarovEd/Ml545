package com.smartloanadvisor.app.ui.state

import com.smartloanadvisor.app.domain.model.Loan

sealed class StatusApplication {
    data object Welcome: StatusApplication()
    data object Main: StatusApplication()

    data object Loans: StatusApplication()
    class Web (
        val url: String,
        val offerName: String
    ): StatusApplication()

    class Offer(val loan: Loan): StatusApplication()

    data object ReconnectFirstLoad : StatusApplication()
    data object Reconnect : StatusApplication()
}
