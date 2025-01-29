package com.uolimzhanov.bttrade.cashRegister.presentation.components.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bttradetest.composeapp.generated.resources.Res
import bttradetest.composeapp.generated.resources.cube
import org.jetbrains.compose.resources.painterResource


@Composable
fun ProductQuantity(
    modifier: Modifier,
    quantity: Int,
    unitType: String
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(
            painter = painterResource(Res.drawable.cube),
            tint = Color.Gray,
            modifier = Modifier.size(20.dp),
            contentDescription = null
        )
        Text(
            text = "$quantity $unitType",
            color = Color.Gray,
            fontSize = 14.sp,
            lineHeight = 18.sp
        )
    }
}