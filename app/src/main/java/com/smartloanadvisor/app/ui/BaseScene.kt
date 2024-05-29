package com.smartloanadvisor.app.ui

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.smartloanadvisor.app.ui.state.MainEvent
import com.smartloanadvisor.app.ui.state.MainViewModel
import com.smartloanadvisor.app.ui.state.StatusApplication

@Composable
fun BaseScene(
    viewModel: MainViewModel = hiltViewModel(),
) {

    val state = viewModel.state.collectAsState()

    val loanLazyState = rememberLazyListState()
    val event = viewModel::onEvent
    when (val currentState = state.value.statusApplication) {
        StatusApplication.Loans -> {
            LoansScreen(
                loanLazyState = loanLazyState,
                loans = state.value.dbData?.loans ?: emptyList(),
                event = event
            )
        }

        StatusApplication.Main -> {
            val loans = state.value.dbData?.loans?.take(3) ?: emptyList()
            MainScreen(
                popularLoans = loans,
                event = event
            )
        }

        is StatusApplication.Offer -> {
            OfferScreen(
                loan = currentState.loan,
                event = event
            )
        }

        StatusApplication.Reconnect -> {
            NoInternetScreen(
                onClick = {
                    event(MainEvent.Reconnect)
                }
            )
        }

        StatusApplication.ReconnectFirstLoad -> {
            NoInternetScreen(
                onClick = {
                    event(MainEvent.ReconnectFirstLoad)
                }
            )
        }

        is StatusApplication.Web -> {
            WebViewScreen(
                lastState = state.value.lastState,
                url = currentState.url,
                offerName = currentState.offerName,
                onEvent = event
            )
        }

        StatusApplication.Welcome -> {
            WelcomeScreen(
                event = event
            )
        }
    }

}