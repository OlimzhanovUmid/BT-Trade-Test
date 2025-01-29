package com.uolimzhanov.bttrade.shop.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bttradetest.composeapp.generated.resources.Res
import bttradetest.composeapp.generated.resources.change_mode
import bttradetest.composeapp.generated.resources.close
import bttradetest.composeapp.generated.resources.notification
import com.uolimzhanov.bttrade.core.presentation.classicBlue
import com.uolimzhanov.bttrade.core.presentation.lightGreen
import com.uolimzhanov.bttrade.core.presentation.moderatelyRoundedCornerShape
import com.uolimzhanov.bttrade.core.presentation.scarletRed
import org.jetbrains.compose.resources.painterResource

@Composable
fun ShopTopAppBar(
    state: ShopState = ShopState(),
    onAction: (ShopAction) -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.weight(0.55f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ShopInfo(
                modifier = Modifier.weight(1f),
                state = state
            )
            ShiftInfo(
                modifier = Modifier.weight(1f),
                state = state
            )
        }
        ShiftControlPanel(
            modifier = Modifier.weight(0.5f),
            state = state,
            onAction = onAction
        )
    }
}

@Composable
fun ShopInfo(
    modifier: Modifier,
    state: ShopState
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = state.shopName,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "Срок действия: ${state.shopActiveUntil}",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun ShiftInfo(
    modifier: Modifier,
    state: ShopState
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = state.shiftOpenedAt,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Время открытия смены",
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ShiftControlPanel(
    modifier: Modifier,
    state: ShopState,
    onAction: (ShopAction) -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = {
                onAction(ShopAction.CloseShift)
            },
            shape = moderatelyRoundedCornerShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            modifier = Modifier
                .weight(4f)
                .size(221.dp, 64.dp)
        ) {
            Icon(
                painter = painterResource(Res.drawable.close),
                tint = scarletRed,
                contentDescription = null
            )
            Text(
                text = "Закрыть смену",
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
        Button(
            onClick = {
                onAction(ShopAction.CloseShift)
            },
            shape = moderatelyRoundedCornerShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            modifier = Modifier
                .weight(5f)
                .size(221.dp, 64.dp)
        ) {
            Icon(
                painter = painterResource(Res.drawable.change_mode),
                tint = classicBlue,
                contentDescription = null
            )
            Text(
                text = "Кассовый режим",
                fontSize = 18.sp,
                modifier = Modifier.padding(4.dp)
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null
            )
        }
        Button(
            onClick = { },
            modifier = Modifier
                .size(64.dp),
            shape = moderatelyRoundedCornerShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Image(
                painter = painterResource(Res.drawable.notification),
                contentDescription = null
            )
        }
        Row(
            modifier = Modifier
                .weight(4f)
                .height(64.dp)
                .background(
                    color = Color.White,
                    shape = moderatelyRoundedCornerShape
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(56.dp)
                    .background(
                        color = lightGreen,
                        shape = moderatelyRoundedCornerShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = state.employeeInitials,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            Column(
                modifier = Modifier.padding(horizontal = 4.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = state.employeeName,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1
                )
                Text(
                    text = state.employeePosition,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }
    }
}