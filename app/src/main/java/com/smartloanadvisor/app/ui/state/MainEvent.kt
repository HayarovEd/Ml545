package com.smartloanadvisor.app.ui.state


sealed class MainEvent {
    data object ReconnectFirstLoad: MainEvent()
    data object Reconnect : MainEvent()
    class OnChangeStatusApplication(val statusApplication: StatusApplication): MainEvent()
    class UpdateLastStatusApplication(val statusApplication: StatusApplication): MainEvent()
    class OnGoToWeb(
        val urlOffer: String,
        val nameOffer: String
        ): MainEvent()
}
