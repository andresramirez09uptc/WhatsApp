package com.task.wathsapp

import Chat
import ChatListScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.task.wathsapp.ui.theme.WathsappTheme
import com.task.wathsapp.ui.theme.novedades.BottomNavigationBar
import com.task.wathsapp.ui.theme.novedades.WhatsAppScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WathsappTheme {
                ScaffoldWithNavigation()
            }
        }
    }

    @Composable
    fun ScaffoldWithNavigation() {
        var currentScreen by remember { mutableStateOf("novedades") }
        val chats = listOf(
            Chat(name = "John Doe", message = "Hello there!", time = "2:35 PM", unreadCount = 2),
            Chat(name = "Alice", message = "How are you?", time = "1:20 PM"),
            Chat(name = "Bob", message = "Let's meet up.", time = "3:45 PM", unreadCount = 1),
            Chat(name = "Charlie", message = "Good morning!", time = "9:00 AM"),
            Chat(name = "David", message = "See you soon.", time = "11:15 AM", unreadCount = 3),
            Chat(name = "Eve", message = "What's up?", time = "4:30 PM"),
            Chat(name = "Frank", message = "Call me.", time = "5:50 PM", unreadCount = 2),
            Chat(name = "Grace", message = "Meeting at 10.", time = "10:00 AM"),
            Chat(name = "Hank", message = "Lunch?", time = "12:00 PM", unreadCount = 1),
            Chat(name = "Ivy", message = "Check this out.", time = "2:00 PM"),
            Chat(name = "Jack", message = "On my way.", time = "6:15 PM", unreadCount = 4),
            Chat(name = "Karen", message = "Happy Birthday!", time = "8:00 AM"),
            Chat(name = "Leo", message = "Good night.", time = "10:30 PM", unreadCount = 1),
            Chat(name = "Mona", message = "See you tomorrow.", time = "7:45 PM"),
            Chat(name = "Nina", message = "Can you help?", time = "1:10 PM", unreadCount = 2),
            Chat(name = "Oscar", message = "Thanks!", time = "3:20 PM"),
            Chat(name = "Paul", message = "Got it.", time = "4:40 PM", unreadCount = 3),
            Chat(name = "Quinn", message = "Where are you?", time = "5:55 PM"),
            Chat(name = "Rita", message = "Let's go.", time = "6:30 PM", unreadCount = 1),
            Chat(name = "Sam", message = "See you later.", time = "7:20 PM")
        )

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomNavigationBar(
                    onChatClick = { currentScreen = "chats" },
                    onNovedadesClick = { currentScreen = "novedades" }
                )
            }
        ) { innerPadding ->
            when (currentScreen) {
                "chats" -> ChatListScreen(chats = chats, modifier = Modifier.padding(innerPadding))
                else -> WhatsAppScreen(modifier = Modifier.padding(innerPadding))
            }
        }
    }


}
