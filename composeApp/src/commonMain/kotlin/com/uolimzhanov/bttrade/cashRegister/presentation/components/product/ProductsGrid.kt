package com.uolimzhanov.bttrade.cashRegister.presentation.components.product

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bttradetest.composeapp.generated.resources.Res
import bttradetest.composeapp.generated.resources.sale_line
import bttradetest.composeapp.generated.resources.star
import com.uolimzhanov.bttrade.cashRegister.domain.Product
import com.uolimzhanov.bttrade.cashRegister.presentation.CashRegisterAction
import com.uolimzhanov.bttrade.core.presentation.lightGreen
import com.uolimzhanov.bttrade.core.presentation.slightlyRoundedCornerShape
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProductsGrid(
    modifier: Modifier = Modifier,
    products: List<Product>,
    onAction: (CashRegisterAction) -> Unit
) {
    Column(modifier) {
        ProductsHeader(
            modifier = Modifier,
            onAction = onAction
        )
        LazyVerticalGrid(
            modifier = Modifier
                .padding(top = 16.dp)
                .weight(1f),
            columns = GridCells.Fixed(4),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Column(
                    modifier = Modifier
                        .aspectRatio(210 / 228f),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    GridButton(
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        iconResource = Res.drawable.sale_line,
                        text = "Товары со скидкой",
                        onClick = {
                            onAction(CashRegisterAction.OnDiscountedProductsClick)
                        }
                    )
                    GridButton(
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        iconResource = Res.drawable.star,
                        text = "Избранные товары",
                        onClick = {
                            onAction(CashRegisterAction.OnFavoriteProductsClick)
                        }
                    )
                }
            }
            items(products) { product ->
                ProductCard(
                    modifier = Modifier
                        .aspectRatio(210 / 228f)
                        .clip(slightlyRoundedCornerShape)
                        .background(Color.White)
                        .clickable {
                            onAction(CashRegisterAction.OnAddToCartClick(product))
                        },
                    product = product
                )
            }
        }
    }
}

@Composable
fun GridButton(
    modifier: Modifier,
    iconResource: DrawableResource,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = slightlyRoundedCornerShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                painter = painterResource(iconResource),
                tint = lightGreen,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
            Text(
                text = text,
                fontWeight = FontWeight.Medium,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp,
                lineHeight = 18.sp
            )
        }
    }
}