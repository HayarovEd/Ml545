package com.smartloanadvisor.app.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.smartloanadvisor.app.R
import com.smartloanadvisor.app.domain.model.Loan
import com.smartloanadvisor.app.ui.state.MainEvent
import com.smartloanadvisor.app.ui.state.StatusApplication
import com.smartloanadvisor.app.ui.theme.background
import credit.calc.com.ui.uikit.ItemLoan

@Preview
@Composable
private fun Sample() {
    LoansScreen(
        loans = emptyList(),
        event = {},
        loanLazyState = rememberLazyListState()
    )
}


@Composable
fun LoansScreen(
    modifier: Modifier = Modifier,
    loans: List<Loan>,
    event: (MainEvent) -> Unit,
    loanLazyState: LazyListState,
) {
    BackHandler {
        event(MainEvent.OnChangeStatusApplication(StatusApplication.Main))
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = background)
    ) {
        Image(
            modifier = modifier
                .fillMaxWidth(),
            painter = painterResource(id = R.drawable.back_loans),
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )
        LazyColumn(
            modifier = modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth(),
            state = loanLazyState,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(loans) { loan ->
                ItemLoan(
                    loan = loan,
                    event = event
                )
            }
        }
    }

}