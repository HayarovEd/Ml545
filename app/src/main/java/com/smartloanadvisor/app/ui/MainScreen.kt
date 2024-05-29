package com.smartloanadvisor.app.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.smartloanadvisor.app.R
import com.smartloanadvisor.app.domain.model.CbrData
import com.smartloanadvisor.app.domain.model.Loan
import com.smartloanadvisor.app.ui.state.MainEvent
import com.smartloanadvisor.app.ui.state.StatusApplication
import com.smartloanadvisor.app.ui.theme.background
import com.smartloanadvisor.app.ui.theme.black
import com.smartloanadvisor.app.ui.theme.blue
import com.smartloanadvisor.app.ui.theme.grey
import com.smartloanadvisor.app.ui.theme.white
import com.smartloanadvisor.app.ui.uikit.RowCurrency


@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    loan1: Loan?,
    loan2: Loan?,
    loan3: Loan?,
    cbrData: CbrData?,
    event: (MainEvent) -> Unit,
) {
    BackHandler {
        event(MainEvent.OnChangeStatusApplication(StatusApplication.Welcome))
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = background)
            .padding(horizontal = 15.dp, vertical = 25.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (loan1!=null) {
                Card(
                    modifier = modifier
                        .weight(1f)
                        .clickable {
                            event(
                                MainEvent.OnGoToWeb(
                                    nameOffer = loan1.name,
                                    urlOffer = loan1.order
                                )
                            )
                            //event(MainEvent.UpdateLastStatusApplication(StatusApplication.Main))
                        },
                    shape = RoundedCornerShape(15.dp)
                ) {
                    AsyncImage(
                        modifier = modifier,
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(loan1.screen)
                            .decoderFactory(SvgDecoder.Factory())
                            .build(),
                        contentDescription = "",
                        //contentScale = ContentScale.FillHeight
                    )
                }
                Spacer(modifier = modifier.width(15.dp))
            }
            if (loan2!=null) {
                Card(
                    modifier = modifier
                        .weight(1f)
                        .clickable {
                            event(
                                MainEvent.OnGoToWeb(
                                    nameOffer = loan2.name,
                                    urlOffer = loan2.order
                                )
                            )
                            //event(MainEvent.UpdateLastStatusApplication(StatusApplication.Main))
                        },
                    shape = RoundedCornerShape(15.dp)
                ) {
                    AsyncImage(
                        modifier = modifier,
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(loan2.screen)
                            .decoderFactory(SvgDecoder.Factory())
                            .build(),
                        contentDescription = "",
                        //contentScale = ContentScale.FillHeight
                    )
                }
                Spacer(modifier = modifier.width(15.dp))
            }
            if (loan3!=null) {
                Card(
                    modifier = modifier
                        .weight(1f)
                        .clickable {
                            event(
                                MainEvent.OnGoToWeb(
                                    nameOffer = loan3.name,
                                    urlOffer = loan3.order
                                )
                            )
                            //event(MainEvent.UpdateLastStatusApplication(StatusApplication.Main))
                        },
                    shape = RoundedCornerShape(15.dp)
                ) {
                    AsyncImage(
                        modifier = modifier,
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(loan3.screen)
                            .decoderFactory(SvgDecoder.Factory())
                            .build(),
                        contentDescription = "",
                        //contentScale = ContentScale.FillHeight
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(25.dp))
        Row(
            modifier = modifier
                .clickable {
                    event(MainEvent.OnChangeStatusApplication(StatusApplication.Loans))
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.see_all),
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight(500),
                    color = grey,
                ),
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = "",
                tint = grey
            )
        }
        if (cbrData != null) {
            Spacer(modifier = modifier.height(25.dp))
            Text(
                text = stringResource(R.string.currency_course),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = black
                )
            )
            Spacer(modifier = modifier.height(15.dp))
            Row (
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = cbrData.previousDate,
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight(500),
                        color = grey
                    )
                )
                Spacer(modifier = modifier.width(93.dp))
                Text(
                    text = cbrData.date,
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight(500),
                        color = grey
                    )
                )
            }
            Spacer(modifier = modifier.height(5.dp))
            RowCurrency(
                icon = "\$",
                name = cbrData.currency.uSD.charCode,
                prevValue = cbrData.currency.uSD.previous,
                diffValue = cbrData.currency.uSD.changeValue,
                value = cbrData.currency.uSD.value
            )
            Spacer(modifier = modifier.height(2.dp))
            RowCurrency(
                icon = "€",
                name = cbrData.currency.eUR.charCode,
                prevValue = cbrData.currency.eUR.previous,
                diffValue = cbrData.currency.eUR.changeValue,
                value = cbrData.currency.eUR.value
            )
            Spacer(modifier = modifier.height(2.dp))
            RowCurrency(
                icon = "¥",
                name = cbrData.currency.cNY.charCode,
                prevValue = cbrData.currency.cNY.previous,
                diffValue = cbrData.currency.cNY.changeValue,
                value = cbrData.currency.cNY.value
            )
            Spacer(modifier = modifier.height(15.dp))
        }
    }
}