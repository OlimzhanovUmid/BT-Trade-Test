package com.uolimzhanov.bttrade.cashRegister.presentation.components.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uolimzhanov.bttrade.core.extensions.toUzbSums

@Composable
fun ProductPrice(
    modifier: Modifier,
    price: Long,
    hasDiscount: Boolean,
    priceWithDiscount: Long?
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = if (hasDiscount) priceWithDiscount.toUzbSums() else price.toUzbSums(),
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 18.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = if (hasDiscount) Color.Red else Color.Black
        )
        if (hasDiscount) {
            Text(
                text = price.toUzbSums(),
                color = Color.Gray,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textDecoration = TextDecoration.LineThrough
            )
        }
    }
}