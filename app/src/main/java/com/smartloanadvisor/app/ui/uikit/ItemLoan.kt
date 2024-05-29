/*
package credit.calc.com.ui.uikit

import android.util.Log
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import credit.calc.com.R
import credit.calc.com.domain.model.Loan
import com.smartloanadvisor.app.ui.state.MainEvent
import credit.calc.com.ui.theme.background
import credit.calc.com.ui.theme.black
import credit.calc.com.ui.theme.card
import credit.calc.com.ui.theme.violet

@Composable
fun ItemLoan(
    modifier: Modifier  = Modifier,
    loan: Loan,
    onEvent: (MainEvent) -> Unit,
) {
    Log.d("test load image", "image ${loan.image}" )
    Card (
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = card
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp, vertical = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = modifier.width(150.dp),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(loan.image)
                        .decoderFactory(SvgDecoder.Factory())
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth)
                Spacer(modifier = modifier.weight(1f))
                Text(
                    text = loan.name,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(600),
                        color = black
                    )
                )
            }
            Spacer(modifier = modifier.height(28.dp))
            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = violet,
                ),
                contentPadding = PaddingValues(vertical = 9.dp),
                onClick = {
                    onEvent(
                        MainEvent.OnGoToWeb(
                            urlOffer = loan.url,
                            nameOffer = loan.name
                        ))
                }) {
                Text(
                    text = stringResource(R.string.checkout),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(600),
                        color = background
                    )
                )
            }
        }
    }
}*/
