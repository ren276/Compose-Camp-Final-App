package com.sandesh.zomatoclone.screens.homeScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.sandesh.zomatoclone.screens.bottomNavBar.BottomNavBar
import com.sandesh.zomatoclone.screens.commonComponents.AppMainSearchTextField
import com.sandesh.zomatoclone.screens.commonComponents.DropDownGrid
import com.sandesh.zomatoclone.screens.homeScreen.components.FoodTypesHomeScreenCircleGrid
import com.sandesh.zomatoclone.screens.homeScreen.components.HomeScreenFilterItemRow
import com.sandesh.zomatoclone.screens.homeScreen.components.MultipleHomeScreenRestroCards
import com.sandesh.zomatoclone.screens.homeScreen.components.RestaurantsHomeScreenCircleLogoGrid
import com.sandesh.zomatoclone.screens.homeScreen.components.TopAppBarComposable
import com.sandesh.zomatoclone.screens.homeScreen.components.getAllHomeScreenFilterItems
import com.sandesh.zomatoclone.ui.theme.zSystemTopAppBarBgColor

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    val navController = rememberNavController()
    Scaffold(
        backgroundColor = zSystemTopAppBarBgColor,
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .statusBarsPadding(),
                elevation = 0.dp,
                backgroundColor = Color.White
            ) {
                TopAppBarComposable()
            }
        },
        bottomBar = { BottomNavBar(navController = navController, navigator = navigator) }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .fillMaxSize()
                .background(Color.White)
                .padding(bottom = 45.dp),
            ) {
            AppMainSearchTextField()
            HomeScreenFilterItemRow(categories = getAllHomeScreenFilterItems())
            RestaurantsHomeScreenCircleLogoGrid()
            FoodTypesHomeScreenCircleGrid("Eat What Makes You happy")
            DropDownGrid(
                content = { FoodTypesHomeScreenCircleGrid() }
            )
            MultipleHomeScreenRestroCards(noOfRestaurantsAround = 123, navigator = navigator)
        }
    }
}
