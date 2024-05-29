package com.smartloanadvisor.app.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smartloanadvisor.app.R
import com.smartloanadvisor.app.ui.state.MainEvent
import com.smartloanadvisor.app.ui.state.StatusApplication
import com.smartloanadvisor.app.ui.theme.background
import com.smartloanadvisor.app.ui.theme.black
import com.smartloanadvisor.app.ui.theme.blue
import com.smartloanadvisor.app.ui.theme.lightBlack
import com.smartloanadvisor.app.ui.theme.white

@Preview
@Composable
private fun Sample() {
    WelcomeScreen(
        event = {}
    )
}


@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    event: (MainEvent) -> Unit,
) {
    BackHandler {}
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = background)
            .padding(horizontal = 15.dp, vertical = 25.dp)
    ) {
        Column(
            modifier = modifier
                .align(alignment = Alignment.Center)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = modifier
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.welcome_image),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = modifier.height(40.dp))
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(R.string.money_to_card),
                style = TextStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight(600),
                    color = black,
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = modifier.height(25.dp))
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(R.string.fast_money),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = lightBlack,
                ),
                textAlign = TextAlign.Center
            )
        }
        Button(
            modifier = modifier
                .align(alignment = Alignment.BottomCenter)
                .padding(horizontal = 40.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(5.dp),
            contentPadding = PaddingValues(vertical = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = blue
            ),
            onClick = {
                event(MainEvent.OnChangeStatusApplication(StatusApplication.Main))
            }) {
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(R.string.next),
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