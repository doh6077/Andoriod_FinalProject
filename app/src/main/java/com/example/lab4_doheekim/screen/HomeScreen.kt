package com.example.lab4_doheekim.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            TabPagerScreen(mainNavController = navController)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabPagerScreen(mainNavController: NavHostController) {
    val tabs = listOf("Feed", "Profile", "Sign Out")
    val pagerState = rememberPagerState(pageCount = { tabs.size })

    Column {
        CustomTabPager(
            pagerState = pagerState,
            tabs = tabs
        )
    }
}
