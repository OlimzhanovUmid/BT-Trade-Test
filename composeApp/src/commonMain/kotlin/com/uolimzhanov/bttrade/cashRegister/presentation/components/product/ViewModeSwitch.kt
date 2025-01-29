package com.uolimzhanov.bttrade.cashRegister.presentation.components.product

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import bttradetest.composeapp.generated.resources.Res
import bttradetest.composeapp.generated.resources.picture_icon
import bttradetest.composeapp.generated.resources.view_grid
import bttradetest.composeapp.generated.resources.view_list
import com.uolimzhanov.bttrade.cashRegister.presentation.CashRegisterAction
import com.uolimzhanov.bttrade.cashRegister.presentation.ViewMode
import com.uolimzhanov.bttrade.core.extensions.noRippleClickable
import com.uolimzhanov.bttrade.core.presentation.lightGrayishBlue
import org.jetbrains.compose.resources.painterResource

fun ContentDrawScope.drawWithLayer(block: ContentDrawScope.() -> Unit) {
    with(drawContext.canvas.nativeCanvas) {
        val checkPoint = saveLayer(null, null)
        block()
        restoreToCount(checkPoint)
    }
}

@Composable
fun ViewModeSwitch(
    modifier: Modifier = Modifier,
    onAction: (CashRegisterAction) -> Unit
) {
    val iconSize: Dp = 52.dp
    val iconPadding: Dp = 2.dp
    val cornerRadius: Dp = 10.dp

    val items = listOf(
        IconTab(painterResource(Res.drawable.picture_icon), ViewMode.GRID),
        IconTab(painterResource(Res.drawable.view_grid), ViewMode.SMALL_GRID),
        IconTab(painterResource(Res.drawable.view_list), ViewMode.LIST),
    )
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    val indicatorOffset by animateDpAsState(
        targetValue = iconSize * selectedIndex,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
        label = "indicator offset"
    )

    Row(
        modifier = modifier
            .background(
                color = lightGrayishBlue,
                shape = RoundedCornerShape(cornerRadius)
            )
            .width(164.dp)
            .drawWithContent {
                drawWithLayer {
                    drawContent()

                    drawRoundRect(
                        topLeft = Offset(
                            x = indicatorOffset.toPx() + iconPadding.toPx(),
                            iconPadding.toPx()
                        ),
                        size = Size(
                            size.height - 2 * iconPadding.toPx(),
                            size.height - 2 * iconPadding.toPx()
                        ),
                        color = Color.White,
                        cornerRadius = CornerRadius(
                            x = cornerRadius.toPx(),
                            y = cornerRadius.toPx()
                        ),
                        blendMode = BlendMode.DstOver
                    )
                }
            }
    ) {
        items.forEachIndexed { index, item ->
            Box(
                modifier = Modifier
                    .size(iconSize)
                    .padding(iconPadding)
                    .clip(RoundedCornerShape(cornerRadius))
                    .noRippleClickable {
                        selectedIndex = index
                        onAction(CashRegisterAction.OnViewModeChange(item.viewMode))
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = item.icon,
                    tint = if (selectedIndex == index) Color.Black else Color.Gray,
                    contentDescription = null
                )
            }
        }
    }
}

data class IconTab(
    val icon: Painter,
    val viewMode: ViewMode
)