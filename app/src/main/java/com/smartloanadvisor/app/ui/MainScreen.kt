package com.smartloanadvisor.app.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.smartloanadvisor.app.R
import com.smartloanadvisor.app.domain.model.Loan
import com.smartloanadvisor.app.ui.state.MainEvent
import com.smartloanadvisor.app.ui.state.StatusApplication
import com.smartloanadvisor.app.ui.theme.background
import com.smartloanadvisor.app.ui.theme.black
import com.smartloanadvisor.app.ui.theme.blue
import com.smartloanadvisor.app.ui.theme.grey
import com.smartloanadvisor.app.ui.theme.white


@Preview
@Composable
private fun Sample() {
    MainScreen(
        popularLoans = emptyList(),
        event = {},
    )
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    popularLoans: List<Loan>,
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
        Text(
            text = stringResource(R.string.current_offers),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(500),
                color = black,
            ),
        )
        Spacer(modifier = modifier.height(25.dp))
        Card(
            modifier = modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp)
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth(),
            ) {
                Image(
                    modifier = modifier
                        .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.actual_loans),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth
                )
                Row(
                    modifier = modifier
                        .align(alignment = Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.without_references),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight(600),
                            color = white,
                        ),
                    )
                    Button(
                        modifier = modifier,
                        shape = RoundedCornerShape(100.dp),
                        contentPadding = PaddingValues(horizontal = 8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = blue
                        ),
                        onClick = {
                            event(MainEvent.OnChangeStatusApplication(StatusApplication.Loans))
                        }) {
                        Text(
                            text = stringResource(R.string.more_info),
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight(600),
                                color = white,
                            ),
                        )
                    }
                }
            }
        }
        Spacer(modifier = modifier.height(35.dp))
        Text(
            text = stringResource(R.string.popular_offers),
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(500),
                color = black,
            ),
        )
        Spacer(modifier = modifier.height(25.dp))
        LazyRow(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(popularLoans) { loan ->
                Card(
                    modifier = modifier
                        .width(100.dp)
                        .clickable {
                            event(
                                MainEvent.OnGoToWeb(
                                    nameOffer = loan.name,
                                    urlOffer = loan.order
                                )
                            )
                            event(MainEvent.UpdateLastStatusApplication(StatusApplication.Main))
                        },
                    shape = RoundedCornerShape(15.dp)
                ) {
                    AsyncImage(
                        modifier = modifier
                            .fillMaxWidth(),
                        model = loan.screen,
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth
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
    }
}