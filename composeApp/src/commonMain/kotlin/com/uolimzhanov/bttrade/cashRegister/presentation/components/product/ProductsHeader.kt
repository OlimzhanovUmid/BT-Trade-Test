package com.uolimzhanov.bttrade.cashRegister.presentation.components.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bttradetest.composeapp.generated.resources.Res
import bttradetest.composeapp.generated.resources.scan_barcode
import bttradetest.composeapp.generated.resources.search
import com.uolimzhanov.bttrade.cashRegister.presentation.CashRegisterAction
import com.uolimzhanov.bttrade.core.presentation.classicBlue
import com.uolimzhanov.bttrade.core.presentation.coolLightGray
import com.uolimzhanov.bttrade.core.presentation.moderatelyRoundedCornerShape
import com.uolimzhanov.bttrade.core.presentation.slightlyRoundedCornerShape
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsHeader(
    modifier: Modifier = Modifier,
    onAction: (CashRegisterAction) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .background(
                shape = moderatelyRoundedCornerShape,
                color = Color.White
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Cписок продуктов",
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        )
        Row(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            HeaderButton(
                modifier = Modifier.weight(1f).size(112.dp, 56.dp),
                onClick = {},
                icon = painterResource(Res.drawable.search)
            )
            HeaderButton(
                modifier = Modifier.weight(1f).size(112.dp, 56.dp),
                onClick = {},
                icon = painterResource(Res.drawable.scan_barcode)
            )
            ViewModeSwitch(
                modifier = Modifier,
                onAction = onAction
            )
        }
    }
}

@Composable
private fun HeaderButton(
    modifier: Modifier,
    icon: Painter,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = slightlyRoundedCornerShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = coolLightGray,
            contentColor = classicBlue
        )
    ) {
        Icon(icon, null)
    }
}