package com.task.wathsapp.ui.theme.novedades

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.filled.AccountCircle


@Composable
fun WhatsAppScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            TopBar()
            Spacer(modifier = Modifier.height(8.dp))
            StatusSection()
            Spacer(modifier = Modifier.height(8.dp))
            ChannelsSection()
        }
    }
}


@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Novedades", color = Color.White, fontSize = 20.sp)
        Row {
            Icon(Icons.Default.Search, contentDescription = "Buscar", tint = Color.White)
            Spacer(modifier = Modifier.width(16.dp))
            Icon(Icons.Default.MoreVert, contentDescription = "Opciones", tint = Color.White)
        }
    }
}

@Composable
fun StatusItem(isFirst: Boolean = false) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(Color.Gray, CircleShape)
                .padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            if (isFirst) {
                Icon(Icons.Default.Add, contentDescription = "Agregar estado", tint = Color.White)
            } else {
                Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color.White)
            }
        }
        Text(
            if (isFirst) "Mi estado" else "Contacto",
            color = Color.White,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun StatusSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            "Estados",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        LazyRow {
            items(10) { index ->
                StatusItem(isFirst = index == 0)
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Composable
fun ChannelsSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Canales",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text("Explorar", color =  Color(0xFF59BB68), fontSize = 14.sp)
        }
        LazyColumn(modifier = Modifier.padding(vertical = 8.dp)) {
            items(20) {
                ChannelItem()
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun ChannelItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color.DarkGray, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.AccountCircle, contentDescription = "Canal", tint = Color.White)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text("FC Barcelona", color = Color.White, fontWeight = FontWeight.Bold)
            Text("SUNDAY NIGHT FOOTBALL", color = Color.Gray, fontSize = 12.sp)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text("2:35 p.m.", color = Color.Gray, fontSize = 12.sp)
            Box(
                modifier = Modifier
                    .background( Color(0xFF59BB68), CircleShape)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text("182", color =  Color.White, fontSize = 12.sp)
            }
        }
    }
}

