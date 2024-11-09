package com.task.wathsapp.ui.theme.novedades

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    onChatClick: () -> Unit,
    onNovedadesClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFF121212))
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavigationItem(
            icon = Icons.AutoMirrored.Filled.Chat,
            label = "Chats",
            unreadCount = 5,
            onClick = onChatClick
        )
        BottomNavigationItem(
            icon = Icons.Default.Visibility,
            label = "Novedades",
            isSelected = true,
            onClick = onNovedadesClick
        )
        BottomNavigationItem(
            icon = Icons.Default.Group,
            label = "Comunidades"
        )
        BottomNavigationItem(
            icon = Icons.Default.Call,
            label = "Llamadas"
        )
    }
}

@Composable
fun BottomNavigationItem(
    icon: ImageVector,
    label: String,
    isSelected: Boolean = false,
    unreadCount: Int = 0,
    notificationColor: Color = Color(0xFF59BB68),
    onClick: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = if (isSelected) Color(0xFF128C7E) else Color.White,
                modifier = Modifier.size(24.dp)
            )
            if (unreadCount > 0) {
                Box(
                    modifier = Modifier
                        .size(16.dp)
                        .background(notificationColor, CircleShape)
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = unreadCount.toString(),
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
            }
        }
        Text(
            text = label,
            color = if (isSelected) Color(0xFF128C7E) else Color.White,
            fontSize = 10.sp
        )
    }
}
