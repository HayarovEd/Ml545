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
import com.smartloanadvisor.app.ui.theme.background
import com.smartloanadvisor.app.ui.theme.black
import com.smartloanadvisor.app.ui.theme.blue
import com.smartloanadvisor.app.ui.theme.white

@Preview
@Composable
private fun Sample() {
    NoInternetScreen(
        onClick = {}
    )
}


@Composable
fun NoInternetScreen(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
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
                modifier = modifier,
                painter = painterResource(id = R.drawable.no_connection),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = modifier.height(50.dp))
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(R.string.no_connection),
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight(600),
                    color = black,
                ),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = modifier.height(24.dp))
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(R.string.try_again),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    color = black,
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
            onClick = onClick
        ) {
            Text(
                modifier = modifier.fillMaxWidth(),
                text = stringResource(R.string.reconnect),
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