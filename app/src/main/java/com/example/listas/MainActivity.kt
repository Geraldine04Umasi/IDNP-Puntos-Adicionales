package com.example.listas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TabsExample()
        }
    }
}

@Composable
fun TabsExample() {
    var selectedTabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Tab 1", "Tab 2")

    Column(modifier = Modifier.fillMaxSize()) {
        // Barra de pestañas
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) }
                )
            }
        }

        // Contenido de las pestañas
        when (selectedTabIndex) {
            0 -> TabUnoContent()
            1 -> TabDosContent()
        }
    }
}

@Composable
fun TabUnoContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFB3E5FC)),
        contentAlignment = Alignment.Center
    ) {
        Text("Contenido del Tab 1")
    }
}

@Composable
fun TabDosContent() {
    val frutas = listOf("Manzana", "Plátano", "Pera", "Fresa", "Uva")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF90CAF9))
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFCCBC))
                .padding(8.dp)
        ) {
            items(frutas) { fruta ->
                Text(
                    text = "Fruta: $fruta",
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Color.White)
                        .padding(8.dp)
                )
            }
        }
    }
}