package com.uolimzhanov.bttrade.cashRegister.presentation.components.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bttradetest.composeapp.generated.resources.Res
import bttradetest.composeapp.generated.resources.trash
import com.uolimzhanov.bttrade.cashRegister.domain.CartItem
import com.uolimzhanov.bttrade.cashRegister.presentation.CashRegisterAction
import com.uolimzhanov.bttrade.core.extensions.toUzbSums
import com.uolimzhanov.bttrade.core.presentation.coolLightGray
import com.uolimzhanov.bttrade.core.presentation.moderatelyRoundedCornerShape
import com.uolimzhanov.bttrade.core.presentation.scarletRed
import org.jetbrains.compose.resources.painterResource

@Composable
fun CartListItem(
    modifier: Modifier = Modifier,
    cartItem: CartItem,
    onAction: (CashRegisterAction) -> Unit
) {
    ListItem(
        modifier = modifier,
        colors = ListItemDefaults.colors(containerColor = Color.Transparent),
        headlineContent = {
            Text(text = cartItem.product.name, maxLines = 2, overflow = TextOverflow.Ellipsis)
        },
        trailingContent = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(moderatelyRoundedCornerShape)
                        .background(coolLightGray)
                        .clickable {
                            onAction(CashRegisterAction.OnDecreaseQuantityClick(cartItem))
                        }
                ) {
                    Text("-")
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(48.dp)
                ) {
                    Text(cartItem.quantity.toString())
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(moderatelyRoundedCornerShape)
                        .background(coolLightGray)
                        .clickable {
                            onAction(CashRegisterAction.OnIncreaseQuantityClick(cartItem))
                        }
                ) {
                    Text("+")
                }
                Column(
                    modifier = Modifier.sizeIn(minWidth = 120.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    val price = if (cartItem.product.hasDiscount) {
                        ((cartItem.product.priceWithDiscount ?: 0) * cartItem.quantity).toUzbSums()
                    } else {
                        (cartItem.product.price * cartItem.quantity).toUzbSums()
                    }
                    Text(
                        text = price,
                        fontSize = 18.sp ,
                        fontWeight = FontWeight.SemiBold
                    )
                    if (cartItem.product.hasDiscount) {
                        Text(
                            text = (cartItem.product.price * cartItem.quantity).toUzbSums(),
                            fontSize = 14.sp,
                            color = Color.Gray,
                            textDecoration = TextDecoration.LineThrough
                        )
                    }
                }
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(moderatelyRoundedCornerShape)
                        .clickable {
                            onAction(CashRegisterAction.OnRemoveFromCartClick(cartItem))
                        }
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.trash),
                        contentDescription = null,
                        tint = scarletRed
                    )
                }
            }
        }
    )
}