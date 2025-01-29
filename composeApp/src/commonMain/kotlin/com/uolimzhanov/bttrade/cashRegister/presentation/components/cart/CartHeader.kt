package com.uolimzhanov.bttrade.cashRegister.presentation.components.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bttradetest.composeapp.generated.resources.Res
import bttradetest.composeapp.generated.resources.barcode_line
import bttradetest.composeapp.generated.resources.classify_2_line
import bttradetest.composeapp.generated.resources.sale_line
import bttradetest.composeapp.generated.resources.time_line
import bttradetest.composeapp.generated.resources.user_add_2_line
import com.uolimzhanov.bttrade.core.presentation.classicBlue
import com.uolimzhanov.bttrade.core.presentation.coolLightGray
import com.uolimzhanov.bttrade.core.presentation.moderatelyRoundedCornerShape
import org.jetbrains.compose.resources.painterResource

@Composable
fun CartHeader(
    modifier: Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Продажа",
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        )
        Button(
            onClick = {
                expanded = !expanded
            },
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
                .height(56.dp),
            shape = moderatelyRoundedCornerShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = coolLightGray,
                contentColor = Color.Black
            )
        ) {
            Text(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = "Аванс"
            )
            Icon(
                modifier = Modifier.align(Alignment.CenterVertically),
                imageVector = if (expanded) {
                    Icons.Outlined.KeyboardArrowUp
                } else {
                    Icons.Outlined.KeyboardArrowDown
                },
                contentDescription = null
            )
        }
    }
    HorizontalDivider()
    Toolbar()
}

@Composable
fun Toolbar() {
    val lineItems = listOf(
        Res.drawable.user_add_2_line to "Добавить клиента",
        Res.drawable.sale_line to "Скидка",
        Res.drawable.barcode_line to "Маркировка",
        Res.drawable.time_line to "Отложенные чеки",
        Res.drawable.classify_2_line to "Больше"
    )
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.height(IntrinsicSize.Min)
    ) {
        lineItems.forEachIndexed { index, item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(12.dp)
                    .weight(1f)
            ) {
                Icon(
                    painter = painterResource(item.first),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = classicBlue
                )
                Text(
                    text = item.second,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    softWrap = false
                )
            }
            if (index < lineItems.size - 1) {
                VerticalDivider()
            }
        }
    }
}