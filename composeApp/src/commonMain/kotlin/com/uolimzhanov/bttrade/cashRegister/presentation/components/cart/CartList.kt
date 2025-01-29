package com.uolimzhanov.bttrade.cashRegister.presentation.components.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.uolimzhanov.bttrade.cashRegister.domain.CartItem
import com.uolimzhanov.bttrade.cashRegister.presentation.CashRegisterAction
import com.uolimzhanov.bttrade.core.extensions.toUzbSums
import com.uolimzhanov.bttrade.core.presentation.coolLightGray
import com.uolimzhanov.bttrade.core.presentation.highlyRoundedCornerShape
import com.uolimzhanov.bttrade.core.presentation.lightGreen
import com.uolimzhanov.bttrade.core.presentation.moderatelyRoundedCornerShape
import com.uolimzhanov.bttrade.core.presentation.scarletRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartList(
    modifier: Modifier = Modifier,
    cartItems: List<CartItem>,
    onAction: (CashRegisterAction) -> Unit
) {
    Card(
        modifier = modifier,
        shape = moderatelyRoundedCornerShape,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        CartHeader(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        )
        HorizontalDivider()
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(20.dp)
        ) {
            itemsIndexed(cartItems) { index, cartItem ->
                CartListItem(
                    modifier = Modifier,
                    cartItem = cartItem,
                    onAction = onAction
                )
                if (index < cartItems.size - 1) {
                    HorizontalDivider()
                }
            }
        }
        HorizontalDivider(Modifier.padding(horizontal = 20.dp))
        Checkout(
            modifier = Modifier.padding(20.dp),
            cartItems = cartItems
        )
    }
}

@Composable
fun Checkout(
    modifier: Modifier = Modifier,
    cartItems: List<CartItem>
) {
    Column(modifier = modifier) {
        Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 24.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Общая сумма")
                Text(
                    text = cartItems.sumOf { it.product.price }.toUzbSums()
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Скидка")
                Text(
                    text = cartItems.sumOf {
                        it.product.priceWithDiscount?.minus(it.product.price) ?: 0
                    }.toUzbSums(),
                    color = scarletRed,
                    textDecoration = TextDecoration.LineThrough
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Итого")
                Text(
                    text = cartItems.sumOf { it.product.priceWithDiscount ?: it.product.price }
                        .toUzbSums()
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                modifier = Modifier.weight(1f).heightIn(min = 96.dp),
                onClick = {},
                shape = highlyRoundedCornerShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = coolLightGray,
                    contentColor = Color.Black
                )
            ) {
                Text("Удалить чек")
            }
            Button(
                modifier = Modifier.weight(1f).heightIn(min = 96.dp),
                onClick = {},
                shape = highlyRoundedCornerShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = coolLightGray,
                    contentColor = Color.Black
                )
            ) {
                Text("Отложить чек")
            }
            Button(
                modifier = Modifier.weight(2f).heightIn(min = 96.dp),
                onClick = {},
                shape = highlyRoundedCornerShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = lightGreen
                )

            ) {
                Text("Оплата")
            }
        }
    }
}