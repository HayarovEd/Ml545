/*
package credit.calc.com.ui.uikit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import credit.calc.com.R
import credit.calc.com.ui.theme.background
import credit.calc.com.ui.theme.black
import credit.calc.com.ui.theme.green
import credit.calc.com.ui.theme.grey

@Composable
fun UiTextField(
    modifier: Modifier = Modifier,
    holderText: String,
    maxLength:Int = 500,
    icon:ImageVector?,
    keyboardType: KeyboardType = KeyboardType.Text,
    content: MutableState<String>,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(12.dp)),
            shape = RoundedCornerShape(12.dp),
            textStyle = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.gilroy)),
                fontWeight = FontWeight(500),
                color = black
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            placeholder = {
                Text(
                    text = holderText,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.gilroy)),
                        fontWeight = FontWeight(500),
                        color = grey
                    )
                )
            },
            leadingIcon = {
                if (icon!=null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "",
                        tint = grey
                    )
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = grey.copy(alpha = 0.1f),
                focusedContainerColor = background,
                focusedBorderColor = green,
                cursorColor = green
            ),
            maxLines = 1,
            value = content.value,
            onValueChange = {
                if (content.value.length<maxLength) {
                    content.value = it
                }
            }
        )
    }
}*/
