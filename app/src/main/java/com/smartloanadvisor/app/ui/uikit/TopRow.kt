/*
package credit.calc.com.ui.uikit

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import credit.calc.com.R
import credit.calc.com.ui.theme.background
import credit.calc.com.ui.theme.black

@Composable
fun TopRow(
    modifier: Modifier = Modifier,
    title:String = stringResource(R.string.make_loan),
    onClickBack: () -> Unit,
) {
    Row(modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 24.dp, vertical = 15.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Button(
            modifier = modifier
                .shadow(elevation = 24.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = background
            ),
            shape = RoundedCornerShape(15.dp),
            onClick = onClickBack,
            contentPadding = PaddingValues(15.dp)
            ) {
            Icon(
                imageVector = Icons.Filled.ArrowBackIosNew,
                contentDescription = "",
                tint = black
            )
        }
        Spacer(modifier = modifier.width(28.dp))
        Text(
            modifier = modifier,
            text = title,
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.gilroy)),
                fontWeight = FontWeight(600),
                color = black
            )
        )
    }
}*/
