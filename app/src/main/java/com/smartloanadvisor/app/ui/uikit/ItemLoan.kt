package credit.calc.com.ui.uikit

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.smartloanadvisor.app.R
import com.smartloanadvisor.app.domain.model.Loan
import com.smartloanadvisor.app.domain.utils.VALUE_ONE
import com.smartloanadvisor.app.ui.state.MainEvent
import com.smartloanadvisor.app.ui.state.StatusApplication
import com.smartloanadvisor.app.ui.theme.black
import com.smartloanadvisor.app.ui.theme.blue
import com.smartloanadvisor.app.ui.theme.lightBlue
import com.smartloanadvisor.app.ui.theme.white
import com.smartloanadvisor.app.ui.uikit.RowCard

@Composable
fun ItemLoan(
    modifier: Modifier = Modifier,
    loan: Loan,
    event: (MainEvent) -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = white
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                modifier = modifier
                    .fillMaxWidth()
                    .clickable {
                        event(
                            MainEvent.OnGoToWeb(
                                nameOffer = loan.name,
                                urlOffer = loan.order
                            )
                        )
                        event(MainEvent.UpdateLastStatusApplication(StatusApplication.Loans))
                    },
                model = ImageRequest.Builder(LocalContext.current)
                    .data(loan.screen)
                    .decoderFactory(SvgDecoder.Factory())
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = modifier.height(13.dp))
            Text(
                text = loan.name,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    color = black
                )
            )
            Spacer(modifier = modifier.height(13.dp))
            LoanCharacteristic(
                title = stringResource(R.string.amounts),
                value = loan.amounts
            )
            if (loan.hidePercentFields == VALUE_ONE) {
                Spacer(modifier = modifier.height(13.dp))
                LoanCharacteristic(
                    title = stringResource(R.string.rate),
                    value = loan.percent
                )
            }
            if (loan.hideTermFields == VALUE_ONE) {
                Spacer(modifier = modifier.height(13.dp))
                LoanCharacteristic(
                    title = stringResource(R.string.period),
                    value = loan.terms
                )
            }
            Spacer(modifier = modifier.height(13.dp))
            RowCard(
                showVisa = loan.showVisa,
                showMaster = loan.showMastercard,
                showYandex = loan.showYandex,
                showMir = loan.showMir,
                showQivi = loan.showQiwi,
                showCache = loan.showCash
            )
            Spacer(modifier = modifier.height(13.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(
                    modifier = modifier
                        .weight(1f),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = lightBlue,
                    ),
                    contentPadding = PaddingValues(vertical = 12.dp),
                    onClick = {
                        event(MainEvent.OnChangeStatusApplication(StatusApplication.Offer(loan)))
                        event(MainEvent.UpdateLastStatusApplication(StatusApplication.Loans))
                    }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.baseline_more_horiz_24),
                        contentDescription = "",
                        tint = black
                    )
                }
                Spacer(modifier = modifier.width(9.dp))
                Button(
                    modifier = modifier
                        .weight(3f),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = blue,
                    ),
                    contentPadding = PaddingValues(vertical = 12.dp),
                    onClick = {
                        event(
                            MainEvent.OnGoToWeb(
                                nameOffer = loan.name,
                                urlOffer = loan.order
                            )
                        )
                        event(MainEvent.UpdateLastStatusApplication(StatusApplication.Loans))
                    }
                ) {
                    Text(
                        text = loan.orderButtonText,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight(700),
                            color = white
                        )
                    )
                }
            }
        }
    }
}