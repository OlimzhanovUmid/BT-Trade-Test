package com.uolimzhanov.bttrade.cashRegister.presentation.components.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bttradetest.composeapp.generated.resources.Res
import bttradetest.composeapp.generated.resources.Weight
import bttradetest.composeapp.generated.resources.basket_off
import coil3.compose.AsyncImage
import com.uolimzhanov.bttrade.cashRegister.domain.Product
import com.uolimzhanov.bttrade.core.presentation.scarletRed
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    product: Product
) {
    Column(
        modifier = modifier
    ) {
        ProductImage(
            product = product,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, top = 8.dp)
                .weight(1f)
        )
        ProductDescription(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, bottom = 12.dp, top = 4.dp)
                .weight(1f),
            product = product
        )
    }
}

@Composable
fun ProductImage(
    modifier: Modifier,
    product: Product
) {
    Box(modifier) {
        AsyncImage(
            modifier = Modifier.align(Alignment.Center).fillMaxSize(),
            model = product.image,
            error = painterResource(Res.drawable.basket_off),
            contentDescription = null
        )
        if (product.hasDiscount) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .wrapContentSize()
                    .padding(8.dp)
                    .background(
                        color = scarletRed,
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                Text(
                    text = "-${product.discountPercent}%",
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    color = Color.White,
                    modifier = Modifier.padding(2.dp)
                )
            }
        }
        if (product.unitType.equals("кг", true)) {
            Image(
                painter = painterResource(Res.drawable.Weight),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun ProductDescription(
    modifier: Modifier,
    product: Product
) {
    Column(modifier) {
        Text(
            modifier = Modifier,
            text = product.name,
            fontSize = 14.sp,
            maxLines = 2,
            lineHeight = 18.sp,
            overflow = TextOverflow.Ellipsis
        )
        ProductQuantity(
            modifier = modifier,
            quantity = product.quantityInStock,
            unitType = product.unitType
        )
        ProductPrice(
            modifier = Modifier
                .wrapContentSize(),
            price = product.price,
            hasDiscount = product.hasDiscount,
            priceWithDiscount = product.priceWithDiscount
        )
    }
}