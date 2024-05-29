package credit.calc.com.ui.uikit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.smartloanadvisor.app.ui.theme.black

@Preview
@Composable
private fun Sample() {
    LoanCharacteristic(
        title = "Суммы:",
        value = "от 1000 до 100 000 ₽"
    )
}


@Composable
fun LoanCharacteristic(
    modifier: Modifier = Modifier,
    title: String,
    value:String
) {
    Row (
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight(400),
                color = black
            )
        )
        Text(
            text = value,
            style = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight(700),
                color = black
            )
        )
    }
}