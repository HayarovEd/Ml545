package com.smartloanadvisor.app.ui

import android.widget.TextView
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.smartloanadvisor.app.R
import com.smartloanadvisor.app.domain.model.Loan
import com.smartloanadvisor.app.domain.utils.VALUE_ONE
import com.smartloanadvisor.app.ui.state.MainEvent
import com.smartloanadvisor.app.ui.state.StatusApplication
import com.smartloanadvisor.app.ui.theme.background
import com.smartloanadvisor.app.ui.theme.black
import com.smartloanadvisor.app.ui.theme.blue
import com.smartloanadvisor.app.ui.theme.white
import com.smartloanadvisor.app.ui.uikit.RowCard
import credit.calc.com.ui.uikit.LoanCharacteristic


@Composable
fun OfferScreen(
    modifier: Modifier = Modifier,
    loan: Loan,
    event: (MainEvent) -> Unit,
) {
    BackHandler {
        event(MainEvent.OnChangeStatusApplication(StatusApplication.Loans))
    }
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        containerColor = background,
        topBar = {
            Row(
                modifier = modifier,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = {
                        event(MainEvent.OnChangeStatusApplication(StatusApplication.Loans))
                    }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_back_ios_24),
                        contentDescription = "",
                        tint = blue
                    )

                }
                Spacer(modifier = modifier.width(6.dp))
                Text(
                    text = loan.name,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600),
                        color = black
                    )
                )
            }
        }
    ) { paddings ->
        Column(
            modifier = modifier
                .padding(paddings)
                .fillMaxWidth()
                .padding(15.dp)
                .verticalScroll(rememberScrollState())
        ) {
            AsyncImage(
                modifier = modifier
                    .fillMaxWidth()
                /*.clickable {
                    event(
                        MainEvent.OnGoToWeb(
                            nameOffer = loan.name,
                            urlOffer = loan.order
                        )
                    )
                    event(MainEvent.UpdateLastStatusApplication(StatusApplication.Loans))
                }*/,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(loan.screen)
                    .decoderFactory(SvgDecoder.Factory())
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = modifier.height(19.dp))
            AndroidView(
                modifier = modifier
                    .fillMaxWidth(),
                factory = { context -> TextView(context) },
                update = {
                    it.setTextColor(R.color.white)
                    it.text = HtmlCompat.fromHtml(
                        loan.description,
                        HtmlCompat.FROM_HTML_MODE_COMPACT
                    )
                }
            )
            Spacer(modifier = modifier.height(45.dp))
            LoanCharacteristic(
                modifier = modifier.background(color = white),
                title = stringResource(R.string.amounts),
                value = loan.amounts
            )
            if (loan.hidePercentFields == VALUE_ONE) {
                Spacer(modifier = modifier.height(6.dp))
                LoanCharacteristic(
                    modifier = modifier.background(color = white),
                    title = stringResource(R.string.rate),
                    value = loan.percent
                )
            }
            if (loan.hideTermFields == VALUE_ONE) {
                Spacer(modifier = modifier.height(6.dp))
                LoanCharacteristic(
                    modifier = modifier.background(color = white),
                    title = stringResource(R.string.period),
                    value = loan.terms
                )
            }
            Spacer(modifier = modifier.height(24.dp))
            RowCard(
                showVisa = loan.showVisa,
                showMaster = loan.showMastercard,
                showYandex = loan.showYandex,
                showMir = loan.showMir,
                showQivi = loan.showQiwi,
                showCache = loan.showCash
            )
            Spacer(modifier = modifier.height(24.dp))
            Button(
                modifier = modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                contentPadding = PaddingValues(vertical = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = blue
                ),
                onClick = {
                    event(
                        MainEvent.OnGoToWeb(
                            nameOffer = loan.name,
                            urlOffer = loan.order
                        )
                    )
                    event(
                        MainEvent.UpdateLastStatusApplication(
                            StatusApplication.Offer(
                                loan = loan
                            )
                        )
                    )
                }) {
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = loan.orderButtonText,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        color = white,
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}