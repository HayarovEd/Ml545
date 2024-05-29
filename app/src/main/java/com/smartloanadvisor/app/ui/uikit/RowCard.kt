package com.smartloanadvisor.app.ui.uikit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.smartloanadvisor.app.R
import com.smartloanadvisor.app.domain.utils.VALUE_ONE

@Composable
fun RowCard(
    modifier: Modifier = Modifier,
    showVisa: String,
    showMaster: String,
    showYandex: String,
    showMir: String,
    showQivi: String,
    showCache: String
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(showVisa== VALUE_ONE) {
            Image(
                modifier = modifier
                    .height(30.dp)
                    .weight(1f),
                imageVector = ImageVector.vectorResource(id = R.drawable.visa),
                contentDescription = "",
                contentScale = ContentScale.FillHeight)
        }
        if(showMaster== VALUE_ONE) {
            Image(
                modifier = modifier
                    .height(30.dp)
                    .weight(1f),
                imageVector = ImageVector.vectorResource(id = R.drawable.master),
                contentDescription = "",
                contentScale = ContentScale.FillHeight)
        }
        if(showYandex== VALUE_ONE) {
            Image(
                modifier = modifier
                    .height(30.dp)
                    .weight(1f),
                imageVector = ImageVector.vectorResource(id = R.drawable.y_money),
                contentDescription = "",
                contentScale = ContentScale.FillHeight)
        }
        if(showMir== VALUE_ONE) {
            Image(
                modifier = modifier
                    .height(30.dp)
                    .weight(1f),
                imageVector = ImageVector.vectorResource(id = R.drawable.mir),
                contentDescription = "",
                contentScale = ContentScale.FillHeight)
        }
        if(showQivi== VALUE_ONE) {
            Image(
                modifier = modifier
                    .height(30.dp)
                    .weight(1f),
                imageVector = ImageVector.vectorResource(id = R.drawable.qivi),
                contentDescription = "",
                contentScale = ContentScale.FillHeight)
        }
        if(showCache== VALUE_ONE) {
            Image(
                modifier = modifier
                    .height(30.dp)
                    .weight(1f),
                imageVector = ImageVector.vectorResource(id = R.drawable.cash),
                contentDescription = "",
                contentScale = ContentScale.FillHeight)
        }
    }
}