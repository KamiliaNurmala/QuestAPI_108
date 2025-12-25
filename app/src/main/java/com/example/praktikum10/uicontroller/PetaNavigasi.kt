package com.example.praktikum10.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.praktikum10.uicontroller.route.DestinasiEntry
import com.example.praktikum10.uicontroller.route.DestinasiHome
import com.example.praktikum10.view.EntrySiswaScreen
import com.example.praktikum10.view.HomeScreen

@Composable
fun DataSiswaApp(navController: NavHostController = rememberNavController(),
                 modifier: Modifier = Modifier.Companion
){
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier.Companion
){
    NavHost(
        navController = navController, startDestination = DestinasiHome.route,
        modifier = Modifier.Companion
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = {
//                    navController.navigate("${DestinasiDetail.route}/${it}")
                })
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.navigate(DestinasiHome.route) })
        }
    }
}